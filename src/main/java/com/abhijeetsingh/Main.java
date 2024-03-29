package com.abhijeetsingh;

import com.abhijeetsingh.config.PaymentGatewayConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello!");
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(PaymentGatewayConfig.class);
        PaymentGateWay gateWay = context.getBean("razorpayObj", RazorpayPaymentGateway.class);
        gateWay.makePayment();
    }
}