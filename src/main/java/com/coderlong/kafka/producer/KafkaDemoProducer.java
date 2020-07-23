/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: KafkaProducer
 * Author:   coderlong
 * Date:     2019/4/14 19:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.producer;

import com.coderlong.kafka.consumer.AbstractConsumer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/14
 * @since 1.0.0
 */
public class KafkaDemoProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDemoProducer.class);
    private static Properties properties = null;
    private static final String DEMO_TOPIC = "test";
    private static final String KAFKA_PRODUCE_CONFIG_PATH = "kafka_producer.properties";

    static {
        properties = new Properties();
        try {
            InputStream inputStream =
                    AbstractConsumer.class.getClassLoader().getResourceAsStream(KAFKA_PRODUCE_CONFIG_PATH);
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void send() {

        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            for (int i = 0; i < 10000; i++) {
                String msg = "This is Message " + i;
                producer.send(new ProducerRecord<String, String>(DEMO_TOPIC, msg));
                LOGGER.info("send message : {}", msg);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
//
//    public CompletableFuture<Boolean> sendSync(byte[] msg) {
//
//        CompletableFuture.supplyAsync()
//    }

    public static void main(String[] args) {
        KafkaDemoProducer kafkaDemoProducer = new KafkaDemoProducer();
        kafkaDemoProducer.send();
    }
}