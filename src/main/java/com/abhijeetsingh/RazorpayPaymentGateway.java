package com.abhijeetsingh;

import org.springframework.stereotype.Component;

@Component("razorpayObj")
public class RazorpayPaymentGateway implements PaymentGateWay{
    @Override
    public void makePayment() {
        System.out.println("making payment using razorpay");
    }

    @Override
    public void cancelPayment() {
        System.out.println("cancelling payment using razorpay");
    }
}
