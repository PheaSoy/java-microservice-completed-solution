package org.soyphea.springoauth2.domain.result;

import org.soyphea.springoauth2.domain.entity.Account;

public class BaseResult {

    private String status;
    private String message;
    private Account account;

    public BaseResult() {
        status = Status.SUCCESS;
        message= "Successfully performed";
    }

    public BaseResult(Account account) {
        status = Status.SUCCESS;
        message= "Successfully performed";
        this.account = account;
    }

    public BaseResult(String status, String message, Account account) {
        this.status = status;
        this.message = message;
        this.account = account;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
