package org.soyphea.springoauth2.domain.entity;


public class Account {

    String accountNo;
    String registerDate;
    Double currentBalance;
    Double avalibleBalance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public Account(String accountNo, String registerDate, Double currentBalance, Double avalibleBalance) {
        super();
        this.accountNo = accountNo;
        this.registerDate = registerDate;
        this.currentBalance = currentBalance;
        this.avalibleBalance = avalibleBalance;
    }

    public Double getAvalibleBalance() {
        return avalibleBalance;
    }

    public void setAvalibleBalance(Double avalibleBalance) {
        this.avalibleBalance = avalibleBalance;
    }

    @Override
    public String toString() {
        return "Account [accountNo=" + accountNo + ", registerDate=" + registerDate + ", currentBalance="
                + currentBalance + ", avalibleBalance=" + avalibleBalance + "]";
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }


}
