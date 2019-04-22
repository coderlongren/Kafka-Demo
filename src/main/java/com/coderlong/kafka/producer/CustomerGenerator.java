/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CustomerGenerator
 * Author:   coderlong
 * Date:     2019/4/19 22:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.producer;

import com.coderlong.kafka.producer.bean.Customer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/19
 * @since 1.0.0
 */
public class CustomerGenerator {
    // 静态工厂方法
    public static Customer getNextCustomer() {
        Customer customer = new Customer();
        long id = System.currentTimeMillis();
        customer.setCustomerID((int)id);
        customer.setCustomerName("name : " + id);
        return  customer;
    }

}