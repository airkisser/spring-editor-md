package com.airkisser.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jun on 2016/5/27.
 */
@Controller
@RequestMapping("/")
public class MdController {

    @RequestMapping
    public String index(){
        return "index";
    }

}
