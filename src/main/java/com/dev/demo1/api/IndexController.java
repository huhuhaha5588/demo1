package com.dev.demo1.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
//@RequestMapping("index")
public class IndexController {

    @RequestMapping("index")
    public String index(Model model){
        log.debug("demo ok ");
        model.addAttribute("title","this is the tiiiiiiitle");
        return "index";
    }

}
