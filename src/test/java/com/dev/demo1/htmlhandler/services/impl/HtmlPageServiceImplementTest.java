package com.dev.demo1.htmlhandler.services.impl;

import com.dev.demo1.htmlhandler.entity.HtmlPage;
import com.dev.demo1.service.HtmlHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.util.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlPageServiceImplementTest {

    @Autowired
    private HtmlPageServiceImplement htmlPageServiceImplement;

    @Autowired
    private HtmlHandlerService htmlHandlerService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getHtmlPages() {
    }

    @Test
    public void getHtmlPage() {
        HtmlPage htmlPage = htmlPageServiceImplement.getHtmlPage(1);
        log.info(htmlPage.toString());
    }


    /**
     * 把
     */
    @Test
    public void isertHtmlPage() throws IOException {
        HtmlPage htmlPage = new HtmlPage();
        //src/main/resources/template-html/
        //从content文件转为string，template-html/content.thml
        File contentFile = new  File("src/main/resources/template-html/content.html");
        String htmlString = FileUtils.readFileToString(contentFile, Charset.forName("utf8"));

        htmlPage.setOrder(2);
        htmlPage.setActive(true);
        htmlPage.setHtml(htmlString);
        htmlPage.setHtmlNoTag(HtmlHandlerService.html2text(htmlString));
        htmlPageServiceImplement.isertHtmlPage(htmlPage);


    }

    @Test
    public void updateHtmlPage() {
    }

    @Test
    public void deleteHtmlPage() {
    }
}