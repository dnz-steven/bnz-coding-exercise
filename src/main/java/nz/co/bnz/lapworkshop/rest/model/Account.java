package nz.co.bnz.lapworkshop.rest.model;

import java.math.BigDecimal;

public class Account {

    public BigDecimal balance;
    public String accountName;

    public Account() {
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}