/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Customer
 * Author:   coderlong
 * Date:     2019/4/19 22:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.producer.bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/19
 * @since 1.0.0
 */
public class Customer {
    private int customerID;
    private String customerName;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer() {
    }

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}