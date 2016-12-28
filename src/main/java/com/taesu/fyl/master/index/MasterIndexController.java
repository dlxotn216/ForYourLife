package com.taesu.fyl.master.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dlxot on 2016-12-26.
 */
@Controller
@RequestMapping(value="/master")
public class MasterIndexController {
    @RequestMapping( value = { "/", "/index", "" }, method = RequestMethod.GET)
    public String readMasterIndexView(){
        return "master/index/index";
    }
}
