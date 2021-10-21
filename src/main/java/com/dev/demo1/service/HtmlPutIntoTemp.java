package com.dev.demo1.service;


import lombok.extern.slf4j.Slf4j;


import org.jodconverter.core.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;


@Slf4j
@Service
public class HtmlPutIntoTemp {

    /**
     *
     * @param htmlContent
     * @param map
     * @return
     */
    public static String replaceHtmlFromString(String htmlContent, Map<String, String> map){
        if(!StringUtils.hasText(htmlContent)){
            return htmlContent;
        }
        //定义${开头 ，}结尾的占位符
        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("${", "}");
        //调用替换
        return propertyPlaceholderHelper.replacePlaceholders(htmlContent, map::get);
    }



    public static String replaceHtmlFromFile(File htmlFile, Map<String, String> map) throws IOException {

        String tempHtmlString = FileUtils.readFileToString(htmlFile, Charset.forName("utf8"));
//        log.info(everything);

        return replaceHtmlFromString(tempHtmlString,map);
    }






}
