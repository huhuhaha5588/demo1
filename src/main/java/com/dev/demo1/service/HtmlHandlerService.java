package com.dev.demo1.service;


import lombok.extern.slf4j.Slf4j;


import org.jodconverter.core.util.FileUtils;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;


@Slf4j
@Service
public class HtmlHandlerService {

    /**
     *  参考Spring源码替换配置文件中${}占位符方式， 由PropertyPlaceholderHelper解析
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


    /**
     *  传入html文件替换占位符
     * @param htmlFile
     * @param map
     * @return
     * @throws IOException
     */
    public static String replaceHtmlFromFile(File htmlFile, Map<String, String> map) throws IOException {

        String tempHtmlString = FileUtils.readFileToString(htmlFile, Charset.forName("utf8"));
        //log.info(everything);

        return replaceHtmlFromString(tempHtmlString,map);
    }


    /**
     * 去除html标签
     * @param html
     * @return
     */
    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    /**
     * 传入html文件去除html标签
     * @param htmlFile
     * @return
     */
    public static String html2textFromFile(File htmlFile) throws IOException {

        String htmlString = FileUtils.readFileToString(htmlFile, Charset.forName("utf8"));
        //log.info(htmlString);
        return html2text(htmlString);
    }






}
