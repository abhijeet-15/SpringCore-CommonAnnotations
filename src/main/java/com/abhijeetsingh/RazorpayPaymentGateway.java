package com.abhijeetsingh;

import org.springframework.stereotype.Component;

//@Component("razorpayObj")
public class RazorpayPaymentGateway implements PaymentGateWay{

    private BankAccount bankAccount;

    public RazorpayPaymentGateway(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    @Override
    public void makePayment() {
        System.out.println("making payment using razorpay");
        System.out.println("Fetching bank account details");
        System.out.println("Account id is " + bankAccount.getAccountId());
    }

    @Override
    public void cancelPayment() {
        System.out.println("cancelling payment using razorpay");
    }
}
