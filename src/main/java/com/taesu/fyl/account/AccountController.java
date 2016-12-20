package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.AccountForSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dlxot on 2016-12-18.
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/account", method= RequestMethod.GET)
    @ResponseBody
    public Object readAccount(){
        return accountService.readAccount();
    }

    @RequestMapping(value="/account/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object readAccountById(@PathVariable  String id){
        AccountForSelect result = accountService.readAccountById(id);

        return result==null ?
                new ResponseEntity<AccountForSelect>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<AccountForSelect>(result, HttpStatus.OK);
    }
}
