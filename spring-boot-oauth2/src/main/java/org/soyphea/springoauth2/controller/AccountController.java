package org.soyphea.springoauth2.controller;

import java.util.Arrays;
import java.util.List;

import org.soyphea.springoauth2.domain.entity.Account;
import org.soyphea.springoauth2.domain.result.BaseResult;
import org.soyphea.springoauth2.domain.result.Status;
import org.soyphea.springoauth2.utils.MessageUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {

    List<Account> accounts = Arrays.
            asList(new Account("000-001", "2018-01-01", 2000.0, 1999.0),
                    new Account("000-009", "2018-01-01", 9000.0, 890.0));

    @GetMapping("/account/{accountNo}")
    public BaseResult getAccountByAccountNo(@PathVariable("accountNo") String accountNo) {

        BaseResult baseResult = new BaseResult();
        baseResult.setMessage(MessageUtils.failBuilder(accountNo));
        baseResult.setStatus(Status.FAIL);

        accounts.stream().filter(account1 -> account1.getAccountNo().equals(accountNo)).findFirst().ifPresent(
                account -> {
                    baseResult.setStatus(Status.SUCCESS);
                    baseResult.setMessage("Account query successfully.");
                    baseResult.setAccount(account);
                }
        );
        return baseResult;
    }

}
