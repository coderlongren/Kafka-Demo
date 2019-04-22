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

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/14
 * @since 1.0.0
 */
public class KafkaDemoProducer {
    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
//            FileInputStream fileInputStream = new FileInputStream(new File("kafka.properties"));
            InputStream inputStream = AbstractConsumer.class.getClassLoader().getResourceAsStream("kafka_producer.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void send() {
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            for (int i = 0; i < 100; i++) {
                String msg = "This is Message " + i;
                producer.send(new ProducerRecord<String, String>("HelloWorld", msg));
                System.out.println("Sent:" + msg);
//                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }

    }
    public void sendSync() {

    }

    public static void main(String[] args) {
        KafkaDemoProducer kafkaDemoProducer = new KafkaDemoProducer();
        kafkaDemoProducer.send();
    }
}