package com.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return "hello";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public String test2() {
        return "Some text";
    }
}
