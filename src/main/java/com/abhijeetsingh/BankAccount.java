package com.abhijeetsingh;

import org.springframework.beans.factory.annotation.Value;

public class BankAccount {

    @Value("${BANK_ACCOUNT_ID}")
    private long accountId;

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return this.accountId;
    }

}
