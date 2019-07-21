package org.soyphea.springoauth2.utils;

public class MessageUtils {

    public static String failBuilder(String accountNo) {
        String failMessage = new StringBuilder("Account").append(" {").append(accountNo).append("} ").append("doesn't exist").toString();
        return failMessage;
    }
}
