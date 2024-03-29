package com.abhijeetsingh;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("razorpayObj")
public class RazorpayPaymentGateway implements PaymentGateWay{

    private BankAccount bankAccount;

    public RazorpayPaymentGateway(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @PostConstruct
    public void init() {
        methodCalledAfterObjectCreation();
    }

    public void methodCalledAfterObjectCreation() {
        System.out.println("Post bean construct method methodCalledAfterObjectCreation has been called");
    }

    @PreDestroy
    public void methodCalledJustBeforeTheBeanIsDestroyed() {
        System.out.println("Pre Destroy method methodCalledJustBeforeTheBeanIsDestroyed has been called");
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
