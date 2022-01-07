package com.dev.demo1.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
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
import java.io.FileNotFoundException;
import java.io.IOException;

//@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterServiceTest {

    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(ConverterServiceTest.class);

    /**
     * 整个类型转换测试类
     * 默认在resources/convert-path/文件夹下操作
     *
     */
    @Value("${config.properties.path.convert:src/main/resources/convert-path/}")
    private String convertPath = "src/main/resources/convert-path/";

    //默认准备好的html文件
    private String htmlInputFileName = "testfroala.html";

    //待转换文件全路径
    private String htmlInputPathAndName;

    //默认准备好的pdf文件
    private String pdfInputFileName = "FroalaByWkhtmltopdf.pdf";

    //待转换文件全路径
    private String pdfInputPathAndName;

    //要转换成格式的后缀名
    private String targetExtensionType = "pdf";

    private ConverterService converterService = new ConverterService();

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


    /**
     * 生成结果: 在以方法名作为文件名的子文件夹下
     */
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
        String outputPath = htmlInputPathAndName.replace(htmlFileName,"html2pdf/"+htmlFileName.replace(".html",".pdf"));

        File pdfOutputFile = new File(outputPath);
        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());
    }


    /**
     * 生成结果: 在以方法名作为文件名的子文件夹下
     */
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


    /**
     * 生成结果: 在以方法名作为文件名的子文件夹下
     */
    @Test
    public void jodConverterhHtml2ppt() {

        htmlInputPathAndName = "src/main/resources/template-html/testThymeleafResult.html";


        File inputFile = new File(htmlInputPathAndName);
        String htmlFileName = inputFile.getName();
        log.info("htmlFileName: {}",htmlFileName);
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pdfOutputPath = htmlInputPathAndName.replace(htmlFileName,"JodConverter-html2pdf"  + File.separator + htmlFileName.replace(".html",".pdf"));
        log.info("pdfOutputPath: {}",pdfOutputPath);
        File pdfOutputFile = new File(pdfOutputPath);
        //若存在先删除
        if(pdfOutputFile.exists()){
            pdfOutputFile.delete();
        }

        String pptOutputPath = htmlInputPathAndName.replace(htmlFileName,"JodConverter-html2pdf"  + File.separator + "openoffice-cmd-pdf2ppt" + File.separator + htmlFileName.replace(".html",".ppt"));
        log.info("pptOutputPath: {}",pptOutputPath);
        File pptOutputFile = new File(pptOutputPath);
        //若存在先删除
        if(pptOutputFile.exists()){
            pptOutputFile.delete();
        }
        try {
            converterService.jodConverterhHtml2ppt(htmlInputPathAndName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());


        //转换后的pdf文件是否生成
        Assert.assertTrue(pptOutputFile.exists());

    }

    /**
     * 生成结果: 在以方法名作为文件名的子文件夹下
     */
    @Test
    public void openOfficeCmdHtml2ppt() {

        htmlInputPathAndName = "src/main/resources/template-html/testThymeleafResult.html";

        File inputFile = new File(htmlInputPathAndName);
        String htmlFileName = inputFile.getName();
        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf

        String pdfOutputPath = htmlInputPathAndName.replace(htmlFileName,"openOfficeCmdHtml2ppt" + File.separator + "cmd-tml2pdf" + File.separator + htmlFileName.replace(".html",".pdf"));
        String pptOutputPath = htmlInputPathAndName.replace(htmlFileName,"openOfficeCmdHtml2ppt" + File.separator + "cmd-tml2pdf" + File.separator + "cmd-pdf2ppt" + File.separator + htmlFileName.replace(".html",".ppt"));
        File pdfOutputFile = new File(pdfOutputPath);
        //若存在先删除
        if(pdfOutputFile.exists()){
            pdfOutputFile.delete();
        }

        File pptOutputFile = new File(pptOutputPath);
        //若存在先删除
        if(pptOutputFile.exists()){
            pptOutputFile.delete();
        }

        try {
            converterService.openOfficeCmdHtml2ppt(htmlInputPathAndName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //转换后的pdf文件是否生成
        Assert.assertTrue(pdfOutputFile.exists());
        //转换后的pdf文件是否生成
        Assert.assertTrue(pptOutputFile.exists());

    }


    /**
     * 生成结果: 在以方法名作为文件名的子文件夹下
     */
    @Test
    public void cmdPDF2PPT() {
//        pdfInputPathAndName = "src/main/resources/convert-path/cmdwkhtmltopdf/testThymeleafResult.pdf";
        pdfInputPathAndName = "src/main/resources/template-html/cmdwkhtmltopdf/testThymeleafResult.pdf";

        File inputFile = new File(pdfInputPathAndName);
        String pdfFileName = inputFile.getName();

        //输出文件路径下新建pdf文件夹，且文件名不变，后缀名改为pdf
        String pptOutputPath = pdfInputPathAndName.replace(pdfFileName,"cmdPDF2PPT/");//+pdfFileName.replace(".ppt",".pdf")
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

    /**
     * 生成结果: 在以方法名作为文件名的子文件夹下
     * 文件夹需要提前创建好
     */

    @Test
    public void cmdwkhtmltopdf() throws IOException {


        htmlInputPathAndName = "src/main/resources/template-html/testThymeleafResult.html";


        File output = new File(htmlInputPathAndName);
        String outputPdfPath =  output.getParent() +  File.separator + "cmdwkhtmltopdf" + File.separator+ "testThymeleafResult.pdf";
        converterService.cmdwkhtmltopdf(htmlInputPathAndName, outputPdfPath);
    }


    @After
    public void tearDown() throws Exception {

        //
        //

    }


}