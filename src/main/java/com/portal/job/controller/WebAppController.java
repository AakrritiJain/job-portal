package com.portal.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
