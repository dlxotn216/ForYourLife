package com.taesu.fyl.master.account;

import com.taesu.fyl.account.AccountService;
import com.taesu.fyl.account.dto.AccountForAuthorityMapping;
import com.taesu.fyl.account.dto.AccountForUpdate;
import com.taesu.fyl.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dlxot on 2016-12-26.
 */
@Controller
@RequestMapping("/master")
public class MasterAccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping( value = "/management/account", method = RequestMethod.GET)
    public String readMasterAccountView(Model model){
        model.addAttribute("accounts", accountService.readAllAccount());
        model.addAttribute("authorities", authorityService.readAuthorities());
        return "master/management/account";
    }

    @RequestMapping( value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public Object readAllAccount(){
        return accountService.readAllAccount();
    }

    @RequestMapping( value = "/accounts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object readAccountById(
            @PathVariable String id
    ){
        return accountService.readAccountById(id);
    }

    @RequestMapping( value = "/accounts/{id}/permit", method = RequestMethod.PUT )
    @ResponseBody
    public Object updateAccountPermitById(
            @PathVariable String id,
            @RequestBody  AccountForUpdate account
    ){
        int result = accountService.updateAccountPermitById(account);
        return result == 1
                ? new ResponseEntity<Object>("OK",HttpStatus.OK)
                 :new ResponseEntity<Object>("NOT FOUND",HttpStatus.NOT_FOUND);
    }

    @RequestMapping( value = "/account/{id}/authority", method = RequestMethod.PUT )
    public Object updateAccountAuthorityById(
            @PathVariable String id,
            AccountForAuthorityMapping accountForAuthorityMapping
    ){
        int result = accountService.updateAccountAuthorityById(accountForAuthorityMapping);

        return result == 1
                ? new ResponseEntity<Object>("OK",HttpStatus.OK)
                :new ResponseEntity<Object>("NOT FOUND",HttpStatus.NOT_FOUND);
    }
}
