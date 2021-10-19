package com.dev.demo1.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandServiceTest {

    @Autowired
    private CommandService commandService;
    @Test
    public void executeCmd() {
        try{
            commandService.executeCmd("soffice --infilter=\"impress_pdf_import\" --convert-to ppt --outdir /Users/johnzhang/testconvertor/ppt/ /Users/johnzhang/testconvertor/pdf/test23.pdf");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}