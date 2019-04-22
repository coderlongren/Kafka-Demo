/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProducerListener
 * Author:   coderlong
 * Date:     2019/4/19 22:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/19
 * @since 1.0.0
 */
public class ProducerListener implements Callback {

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        System.out.println("asynchronous send message completaed : " + metadata.toString());
    }
}