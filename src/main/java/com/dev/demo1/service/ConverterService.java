package com.dev.demo1.service;

import com.aspose.pdf.*;

import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.jodconverter.local.filter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
//import java.nio.file.Paths;
//import java.awt.Color;
//import java.awt.Rectangle;
//import com.spire.presentation.*;
//import com.spire.presentation.drawing.FillFormatType;



@Slf4j

@Service
public class ConverterService {

    @Autowired
    private CommandService commandService;
    /**
     * @inputPathAndName     要转换文件路径的路径
     * @targetExtensionType  目标文件后缀名，要转换成什么格式的后缀名
     *
     */
    public void html2pdf(String inputPathAndName, String targetExtensionType){

        File inputFile = new File(inputPathAndName);
        if(!inputFile.exists()){
            log.info("输入路径文件不存在");
            return ;
        }

        String inputName = inputFile.getName();
        String outputPath = inputFile.getParent() + File.separator + targetExtensionType + File.separator;
        //默认输出路径为：输入路径文件夹下新建一个文件夹（以转换目标）
        log.info("输出路径： " + outputPath);

        //在相同路径下创建新文件格式的文件夹
        File outputPathFile = new File(outputPath);
        if (!outputPathFile.exists()) {
            outputPathFile.mkdirs();
        }

        String outputName = inputName.substring(0,inputName.lastIndexOf("."))+"."+targetExtensionType;

        File outputFile = new File(outputPath+outputName);

        // Create an office manager using the default configuration.
        // The default port is 2002. Note that when an office manager
        // is installed, it will be the one used by default when
        // a converter is created.
        final LocalOfficeManager officeManager = LocalOfficeManager.install();
        try {

            // Start an office process and connect to the started instance (on port 2002).
            officeManager.start();
            long start = System.currentTimeMillis();
            log.info("html2pdf转换开始");
            // Convert
            JodConverter
                    .convert(inputFile)
                    .to(outputFile)
                    .execute();
            long end = System.currentTimeMillis();
            log.info("html2pdf转换结束");
            log.info("耗时: "+(end-start) +"ms");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // Stop the office process
            OfficeUtils.stopQuietly(officeManager);
        }
    }


    public void html2ppt(String inputPathAndName){

        File inputFile = new File(inputPathAndName);
        if(!inputFile.exists()){
            log.info("输入路径文件不存在");
            return ;
        }

        String inputName = inputFile.getName();
        String pdfOutputPath = inputFile.getParent() + File.separator + "pdf" + File.separator;
        //默认输出路径为：输入路径文件夹下新建一个文件夹（以转换目标）
        log.info("pdf输出路径： " + pdfOutputPath);

        //在相同路径下创建新文件格式的文件夹
        File outputPathFile = new File(pdfOutputPath);
        if (!outputPathFile.exists()) {
            outputPathFile.mkdirs();
        }
        String pdfOutputName = inputName.substring(0,inputName.lastIndexOf("."))+".pdf";
        File pdfOutputFile = new File(pdfOutputPath+pdfOutputName);


        //ppt 输出文件
        String pptOutputPath = inputFile.getParent() + File.separator + "ppt" + File.separator;
        //默认输出路径为：输入路径文件夹下新建一个文件夹（以转换目标）
        log.info("ppt输出路径： " + pptOutputPath);

        //在相同路径下创建新文件格式的文件夹
//        File pptputPathFile = new File(pptOutputPath);
//        if (!pptputPathFile.exists()) {
//            pptputPathFile.mkdirs();
//        }
//        String pptOutputName = inputName.substring(0,inputName.lastIndexOf("."))+".ppt";
//        File pptOutputFile = new File(pptOutputPath+pptOutputName);

        // Create an office manager using the default configuration.
        // The default port is 2002. Note that when an office manager
        // is installed, it will be the one used by default when
        // a converter is created.
        final LocalOfficeManager officeManager = LocalOfficeManager.install();
        long start= 0;
        long end = 0;
        try {

            // Start an office process and connect to the started instance (on port 2002).
            officeManager.start();
            start = System.currentTimeMillis();
            log.info("html2ppt转换开始");
            // Convert
            JodConverter
                    .convert(inputFile)
                    .to(pdfOutputFile)
                    .execute();
            end = System.currentTimeMillis();
            log.info("html2ppt转换结束");
            log.info("耗时: "+(end-start) +"ms");
//            final PagesSelectorFilter selectorFilter = new PagesSelectorFilter(2);
////
//            LocalConverter.builder().filterChain(selectorFilter).build()
//                    .convert(inputFile)
//                    .to(pptOutputFile)
//                    .execute();



        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // Stop the office process
            OfficeUtils.stopQuietly(officeManager);
        }
        //转换pdf 到 ppt
        commandService.executeCmd("soffice --infilter=\"impress_pdf_import\" --convert-to ppt --outdir " +
                inputFile.getParent() + "/ppt/ " +
                pdfOutputPath+pdfOutputName);
        end = System.currentTimeMillis();
        log.info("html2ppt转换结束");
        log.info("耗时: "+(end-start) +"ms");
    }


    public void cmdhtml2ppt(String inputPathAndName) {


        File inputFile = new File(inputPathAndName);
        if (!inputFile.exists()) {
            log.info("输入路径文件不存在");
            return;
        }

        String inputName = inputFile.getName();
        String pdfOutputPath = inputFile.getParent() + File.separator + "pdf" + File.separator;
        String pptOutputPath = inputFile.getParent() + File.separator + "ppt" + File.separator;
        //默认输出路径为：输入路径文件夹下新建一个文件夹（以转换目标）
        log.info("pdf输出路径：" + pdfOutputPath);
        log.info("ppt输出路径： " + pptOutputPath);
        long start = System.currentTimeMillis();
//        //转换html 到 pdf
//        commandService.executeCmd("soffice --headless --convert-to pdf --outdir " +
//                pdfOutputPath + " " +
//                inputPathAndName);
//        //转换pdf 到 ppt
//        commandService.executeCmd("soffice --infilter=\"impress_pdf_import\" --convert-to ppt --outdir " +
//                pptOutputPath + " " +
//                pdfOutputPath + inputFile.getName().replace(".html",".pdf"));

//        转换html 到 pdf

        log.info("html2ppt转换开始");
        commandService.executeCmd(
                "soffice --headless --convert-to pdf --outdir " +
                pdfOutputPath + " " +
                inputPathAndName +'\n' +
                "soffice --infilter=\"impress_pdf_import\" --convert-to ppt --outdir " +
                pptOutputPath + " " +
                pdfOutputPath + inputFile.getName().replace(".html",".pdf"));
        long end = System.currentTimeMillis();
        log.info("html2ppt转换结束");
        log.info("耗时: "+(end-start) +"ms");
    }


    /**
     *有水印不使用
     */
    public void pdf2ppt()  {
        // Load PDF document
        Document pdfDocument = new Document("/Users/johnzhang/work-insights/test/Cigna-Express.pdf");
//        Document pdfDocument = new Document("/Users/johnzhang/临时文件夹/开发编程/Office格式转换/Chapter 6 Formatting Pages_ Advanced.pdf");

        // Set PPTX save options
        PptxSaveOptions pptxOptions = new PptxSaveOptions();
        pptxOptions.setSlidesAsImages(true);
        // Save PDF as PPTX
//        pdfDocument.save("/Users/johnzhang/临时文件夹/开发编程/Office格式转换/Chapter 6 Formatting Pages_ Advanced.pptx", pptxOptions);
        pdfDocument.save("/Users/johnzhang/work-insights/test/Cigna-Express.pptx", pptxOptions);
    }




}
