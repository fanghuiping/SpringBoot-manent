package com.fanghuiping.springbootmanent.sys.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class ManentController {
    @GetMapping("login")
    public String login(){
        return "system/index/login";
    }
    @GetMapping("index")
    public String index(){ return "system/index/index"; }
    @GetMapping("deskMain")
    public String deskMain(){ return "system/index/deskMain"; }
    @GetMapping("toLogLoginManager")
    public String toLogLoginManager(){return "system/loginfo/loginfoManager"; }
}
