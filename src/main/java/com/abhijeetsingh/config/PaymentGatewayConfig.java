package com.abhijeetsingh.config;

import com.abhijeetsingh.BankAccount;
import com.abhijeetsingh.PaymentGateWay;
import com.abhijeetsingh.RazorpayPaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan(basePackages = "com.abhijeetsingh")
@PropertySource("classpath:JDBC-Info.properties")

public class PaymentGatewayConfig {

    @Bean
    public BankAccount getBankAccountObj() {
        return new BankAccount();
    }
    @Bean(name = {"razorpayObj"})
    public PaymentGateWay getPaymentGatewayObj() {
        return new RazorpayPaymentGateway(getBankAccountObj());
    }

}
