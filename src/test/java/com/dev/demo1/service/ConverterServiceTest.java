package com.dev.demo1.service;

import org.jodconverter.core.office.OfficeException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterServiceTest {

    //待转换文件路径
    private String inputPathAndName ="/Users/johnzhang/testconvertor/EVERSANA.html";
    //要转换成格式的后缀名
    private String targetExtensionType = "pdf";
    @Autowired
    private ConverterService converterService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void html2pdf() {


        try {
            converterService.html2pdf(inputPathAndName,targetExtensionType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File inputFile = new File(inputPathAndName);
        String htmlFileName = inputFile.getName();
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String outputPath = inputPathAndName.replace(htmlFileName,"pdf/"+htmlFileName.replace(".html",".pdf"));
        File pdfOutputFile = new File(outputPath);
        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());
    }

    @Test
    public void pdf2ppt() {
        converterService.pdf2ppt();
    }

    @Test
    public void html2ppt() {
        File inputFile = new File(inputPathAndName);
        String htmlFileName = inputFile.getName();
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pdfOutputPath = inputPathAndName.replace(htmlFileName,"pdf/"+htmlFileName.replace(".html",".pdf"));
        File pdfOutputFile = new File(pdfOutputPath);
        //若存在先删除
        if(pdfOutputFile.exists()){
            pdfOutputFile.delete();
        }

        String pptOutputPath = inputPathAndName.replace(htmlFileName,"ppt/"+htmlFileName.replace(".html",".ppt"));
        File pptOutputFile = new File(pptOutputPath);
        //若存在先删除
        if(pptOutputFile.exists()){
            pptOutputFile.delete();
        }
        try {
            converterService.html2ppt(inputPathAndName);
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
        File inputFile = new File(inputPathAndName);
        String htmlFileName = inputFile.getName();
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pdfOutputPath = inputPathAndName.replace(htmlFileName,"pdf/"+htmlFileName.replace(".html",".pdf"));
        File pdfOutputFile = new File(pdfOutputPath);
        //若存在先删除
        if(pdfOutputFile.exists()){
            pdfOutputFile.delete();
        }

        String pptOutputPath = inputPathAndName.replace(htmlFileName,"ppt/"+htmlFileName.replace(".html",".ppt"));
        File pptOutputFile = new File(pptOutputPath);
        //若存在先删除
        if(pptOutputFile.exists()){
            pptOutputFile.delete();
        }

        try {
            converterService.cmdhtml2ppt(inputPathAndName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());
        //转换后的pdf文件是否生成
        Assert.assertTrue(pptOutputFile.exists());

    }


    @After
    public void tearDown() throws Exception {


        //

    }


}