/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AvroProducer
 * Author:   coderlong
 * Date:     2019/4/19 22:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.producer;

import com.coderlong.kafka.producer.bean.Customer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/19
 * @since 1.0.0
 */
public class AvroProducer {
    static Properties pro = null;
    static {
        pro = new Properties();
        pro.put("bootstrap.servers", "localhost:9092");
        pro.put("key.serializer", "io.confluent.KafkaAvroSerializer");
        pro.put("value.serializer", "io.confluent..KafkaAvroSerializer");
        pro.put("schema.registry.url", "schemaUrl");
        String topic = "Avrotopic";
    }
    public static void main(String[] args) {

        Producer<String, Customer> producer = new KafkaProducer<String, Customer>(pro);
        ProducerListener callback = new ProducerListener();
        while (true) {
            Customer nextCustomer = CustomerGenerator.getNextCustomer();
            System.out.println("serializer one Customer" + nextCustomer.toString());
            // 提供了多种构造记录方法
            ProducerRecord oneRecord = new ProducerRecord<String ,Customer>("Avrotopic", nextCustomer);
            // 发送完成,自动回调
            producer.send(oneRecord, callback);
        }

    }

}