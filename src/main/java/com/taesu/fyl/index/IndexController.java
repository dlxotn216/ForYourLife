package com.taesu.fyl.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dlxot on 2016-12-22.
 */
@Controller
public class IndexController {
    @RequestMapping( value = { "/", "/index" }, method = RequestMethod.GET )
    public String indexView(){
        return "index/index";
    }
}
