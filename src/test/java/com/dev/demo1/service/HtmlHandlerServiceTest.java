package com.dev.demo1.service;

import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlHandlerServiceTest {
    @Value("${config.properties.path.convert:src/main/resources/template-html/}")
    private String convertPath;

    //模版文件名
    private String template = "template.html";

    //内容文件名
    private String content = "content.html";

    //结果文件名
    private String result = "result.html";

    @Autowired
    private HtmlHandlerService htmlHandlerService;

    //模版文件路径
    private String templatePathAndName;

    //嵌入内容文件路径
    private String contentPathAndName;
    @Before
    public void setUp() throws Exception {
        templatePathAndName = convertPath + template;
        File file1 = new File(templatePathAndName);
        if(!file1.exists())
            Assert.assertTrue("模版文件不存在:" + templatePathAndName,file1.exists());

        contentPathAndName = convertPath + content;
        File file2 = new File(contentPathAndName);
        if(!file2.exists())
            Assert.assertTrue("嵌入内容文件不存在:" + templatePathAndName,file2.exists());


    }

//    @Test
//    public void replaceHtmlFromString() {
//    }

    @Test
    public void replaceHtmlFromFile() throws IOException {

        File contentFile = new  File(contentPathAndName);
        String contentString = FileUtils.readFileToString(contentFile, Charset.forName("utf8"));


        //替换map
        Map<String ,String> map = new HashMap<>();
        map.put("contents",contentString);
        map.put("title","<h1>title<h1>");


        Set<String> keys = map.keySet();
        log.info("想要替换的Key有: " + keys);
        File templateFile = new  File(templatePathAndName);
        String origenTempString = FileUtils.readFileToString(templateFile, Charset.forName("utf8"));

        //
        String resultString = htmlHandlerService.replaceHtmlFromFile(templateFile,map);
        for(String key :keys){
            //模版中是否有要替换的key
            if (origenTempString.contains("${" + key +"}")){
                //有key情况下，应该替换了
                Assert.assertTrue(resultString.contains(map.get(key)));
            }
            else {
                log.error("模版中未包含替换的key ${" + key + "}");
            }
        }
        //log.info("替换模版中的key之后 " + resultString);

        //把最终结果放在result.html文件中
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(convertPath + result));
            bufferedWriter.write(resultString);

        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());

        } finally {
            if (bufferedWriter != null)
                bufferedWriter.close();
        }


    }


    @Test
    public void html2textFromFile() throws IOException {

        File contentFile = new  File(contentPathAndName);
        String text = htmlHandlerService.html2textFromFile(contentFile);
        log.info(text);
    }
}