package com.dev.demo1.api;


import com.dev.demo1.service.HtmlHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
@Controller
//@RequestMapping("index")
public class IndexController {

    @Value("${config.properties.path.convert:src/main/resources/template-html/}")
    private String convertPath;

    @Autowired
    private HtmlHandlerService htmlHandlerService;

    //模版文件名
    private String template = "template.html";

    //内容文件名
    private String content = "content.html";

    @RequestMapping("index")
    public String index(Model model){
        log.debug("demo ok ");

        model.addAttribute("webtitle","这个是页面的标题");

        model.addAttribute("title","这个是ppt的标题");

        File contentsHtmlFile = new File(convertPath,content);
        String htmlString = null;

        try {
            htmlString = FileUtils.readFileToString(contentsHtmlFile, Charset.forName("utf8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        model.addAttribute("htmlcontent",htmlString);
        return "index";
    }

}
