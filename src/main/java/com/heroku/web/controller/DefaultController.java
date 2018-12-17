package com.heroku.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
