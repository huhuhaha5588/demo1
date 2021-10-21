package com.dev.demo1.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterServiceTest {


    @Value("${config.properties.path.convert:src/main/resources/convert-path/}")
    private String convertPath;

    //需要准备好的html文件
    private String htmlInputFileName = "testfroala.html";

    //待转换文件全路径
    private String htmlInputPathAndName;

    //需要准备好的pdf文件
    private String pdfInputFileName = "FroalaByWkhtmltopdf.pdf";

    //待转换文件全路径
    private String pdfInputPathAndName;

    //要转换成格式的后缀名
    private String targetExtensionType = "pdf";
    @Autowired
    private ConverterService converterService;

    @Before
    public void setUp() throws Exception {
        htmlInputPathAndName = convertPath + htmlInputFileName;
        File file1 = new File(convertPath, htmlInputFileName);
        Assert.assertTrue("文件不存在:" + htmlInputPathAndName, file1.exists());

        pdfInputPathAndName = convertPath + pdfInputFileName;
        File file2 = new File(pdfInputPathAndName);
        Assert.assertTrue("文件不存在:" + pdfInputPathAndName, file2.exists());

        log.warn("需要安装libreOffice才能运行");

    }

    @Test
    public void html2pdf() {
        try {
            converterService.html2pdf(htmlInputPathAndName, targetExtensionType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File inputFile = new File(htmlInputPathAndName);
        String htmlFileName = inputFile.getName();
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String outputPath = htmlInputPathAndName.replace(htmlFileName,"pdf/"+htmlFileName.replace(".html",".pdf"));

        File pdfOutputFile = new File(outputPath);
        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());
    }



    @Test
    public void pdf2ppt() {
        File inputFile = new File(pdfInputPathAndName);
        String pdfFileName = inputFile.getName();

        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pptOutputPath = pdfInputPathAndName.replace(pdfFileName,"pdf2ppt/");//+pdfFileName.replace(".ppt",".pdf")
        File pdfOutputFile = new File(pptOutputPath, pdfFileName.replace(".ppt",".pdf"));
        log.info("pdfOutputFile: {}", pdfOutputFile);
        //若存在先删除
        if(pdfOutputFile.exists()){
            log.info("已存在则删除: {}", pdfOutputFile.toString());
            pdfOutputFile.delete();
        }

        log.info("pdfInputPathAndName: {}", pdfInputPathAndName);
        log.info("pptOutputPath: {}", pptOutputPath);

        try {
            converterService.pdf2ppt(pdfInputPathAndName,pptOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void html2ppt() {
        File inputFile = new File(htmlInputPathAndName);
        String htmlFileName = inputFile.getName();
        log.info("htmlFileName: {}",htmlFileName);
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pdfOutputPath = htmlInputPathAndName.replace(htmlFileName,"pdf/"+htmlFileName.replace(".html",".pdf"));
        log.info("pdfOutputPath: {}",pdfOutputPath);
        File pdfOutputFile = new File(pdfOutputPath);
        //若存在先删除
        if(pdfOutputFile.exists()){
            pdfOutputFile.delete();
        }

        String pptOutputPath = htmlInputPathAndName.replace(htmlFileName,"ppt/"+htmlFileName.replace(".html",".ppt"));
        log.info("pptOutputPath: {}",pptOutputPath);
        File pptOutputFile = new File(pptOutputPath);
        //若存在先删除
        if(pptOutputFile.exists()){
            pptOutputFile.delete();
        }
        try {
            converterService.html2ppt(htmlInputPathAndName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());


        //转换后的pdf文件是否生成
        Assert.assertTrue(pptOutputFile.exists());

    }

    @Test
    public void cmdhtml2ppt() {



        File inputFile = new File(htmlInputPathAndName);
        String htmlFileName = inputFile.getName();
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pdfOutputPath = htmlInputPathAndName.replace(htmlFileName,"pdf/"+htmlFileName.replace(".html",".pdf"));
        File pdfOutputFile = new File(pdfOutputPath);
        //若存在先删除
        if(pdfOutputFile.exists()){
            pdfOutputFile.delete();
        }

        String pptOutputPath = htmlInputPathAndName.replace(htmlFileName,"ppt/"+htmlFileName.replace(".html",".ppt"));
        File pptOutputFile = new File(pptOutputPath);
        //若存在先删除
        if(pptOutputFile.exists()){
            pptOutputFile.delete();
        }

        try {
            converterService.cmdhtml2ppt(htmlInputPathAndName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());
        //转换后的pdf文件是否生成
        Assert.assertTrue(pptOutputFile.exists());

    }


    @Test
    public void cmdPDF2PPT() {

        File inputFile = new File(pdfInputPathAndName);
        String pdfFileName = inputFile.getName();

        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pptOutputPath = pdfInputPathAndName.replace(pdfFileName,"cmdpdf2ppt/");//+pdfFileName.replace(".ppt",".pdf")
        File pdfOutputFile = new File(pptOutputPath, pdfFileName.replace(".ppt",".pdf"));
        //若存在先删除
        if(pdfOutputFile.exists()){
            log.info("已存在则先删除: {}", pdfOutputFile.toString());
            pdfOutputFile.delete();
        }

        log.info("pdfInputPathAndName: {}", pdfInputPathAndName);
        log.info("pptOutputPath: {}", pptOutputPath);
        try {
            converterService.cmdPDF2PPT(pdfInputPathAndName,pptOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() throws Exception {


        //

    }


}