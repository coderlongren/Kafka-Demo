/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AbstractConsumer
 * Author:   coderlong
 * Date:     2019/4/14 22:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.consumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/14
 * @since 1.0.0
 */
public class AbstractConsumer<K, V> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConsumer.class);
    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
//            FileInputStream fileInputStream = new FileInputStream(new File("kafka.properties"));
            InputStream inputStream = AbstractConsumer.class.getClassLoader().getResourceAsStream("kafka_consumer.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("receive message error", e);
        }
    }

    /**
     * 在acks = all策略下接收消息
     * lists 需要订阅的主题
     * timeOut 消费端poll消息的超时时间
     * @return
     */
    public void receive(Collection<String> lists, int timeOut) {
        Consumer<K, V> consumer = new KafkaConsumer(properties);
        consumer.subscribe(lists);
        while (true) {
            ConsumerRecords<K, V> records = consumer.poll(timeOut);
            records.forEach(record -> {
                System.out.printf("offset = %d, value = %s", record.offset(), record.value().toString());
                System.out.println("======================>>");
            });
        }

    }

}