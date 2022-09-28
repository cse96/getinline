package com.getinline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//@Controller Bean으로 등록. ->  Container
public class BaseController implements ErrorController {
    @GetMapping("/")//traditional 하게 jsp로 동작해버림. -> thymeleaf를 implementation해야 html동작
    public String root(){
        return "index";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
