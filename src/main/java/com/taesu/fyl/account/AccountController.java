package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.AccountForInsert;
import com.taesu.fyl.account.dto.AccountForUpdate;
import com.taesu.fyl.encoder.UserIdEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dlxot on 2016-12-18.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserIdEncoder userIdEncoder;

    private static Logger log = LoggerFactory.getLogger(AccountController.class);

    /**
     * @api {get} /account/:userId Get Account information
     * @apiVersion 0.1.0
     * @apiName ReadAccountById
     * @apiGroup Account
     *
     * @apiParam {String} userId Users unique ID.
     *
     * @apiSuccess {String} passwd User's encoded password
     * @apiSuccess {String} userName User's name
     *
     * @apiSuccessExample Success-Response:
     *      Http/1.1 200 OK
     *      {
     *          "passwd": "afeaewaar232423rr32r2rrbr",
     *          "userName": "Lee"
     *      }
     *
     * @apiError UserNotFound The id of the User was not found
     *
     */
    @RequestMapping(value="/account/{userId}", method=RequestMethod.GET)
    @ResponseBody
    public Object readAccountById(@PathVariable String userId){
        return accountService.readAccountById(userId);
    }

    @RequestMapping(value="/account/update", method= RequestMethod.GET)
    public String readAccountUpdateView(){
        return "account/update";
    }

    @RequestMapping(value="/account/create", method= RequestMethod.GET)
    public String readAccountView(){
        return "account/create";
    }

    @RequestMapping( value = "/accounts/{userId}/{token}/authentication", method = RequestMethod.POST)
    @ResponseBody
    public String updateUserPermitByuAuthentication(
            @PathVariable String userId,
            @PathVariable String token
    ){
        log.info("DEBUG CHECK authentication "+userId+" "+token);
        accountService.updateUserPermitByAuthToken(token, userId);
        return "";
    }

    @ResponseBody
    @RequestMapping(value="/account", method= RequestMethod.POST)
    public Object createAccount(@RequestBody AccountForInsert account, HttpServletRequest request){
        System.out.println(account.getPasswd());
        System.out.println(account.getUserName());
        System.out.println(account.getUserEmail());

        accountService.createAccount(account, request);
        log.info("create account finished");

        return new ResponseEntity<Object>(HttpStatus.OK);
    }


    @ResponseBody
    @RequestMapping(value="/account/{userId}", method=RequestMethod.PUT)
    public Object updateAccountById(@RequestBody AccountForUpdate accountForUpdate, @PathVariable String userId){
        return accountService.updateAccountById(accountForUpdate, userId)> 0 ?
                new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @RequestMapping(value="/account/{userId}", method=RequestMethod.DELETE)
    public Object deleteAccountById(@PathVariable String userId){
        return accountService.deleteAccount(userId) > 0 ?
                new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
