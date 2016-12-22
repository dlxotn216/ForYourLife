package com.taesu.fyl.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dlxot on 2016-12-22.
 */
@Controller
public class AuthenticationController {
    @RequestMapping(value="/authentication", method= RequestMethod.GET)
    public String authenticationView(){
        return "authentication/authentication";
    }
}
