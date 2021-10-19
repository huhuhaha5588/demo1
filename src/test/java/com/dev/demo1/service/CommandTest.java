package com.dev.demo1.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void exeCmd() {
        String commandStr = "soffice --infilter=\"impress_pdf_import\" --convert-to ppt --outdir /Users/johnzhang/testconvertor/ppt/ /Users/johnzhang/testconvertor/pdf/test2.pdf";
        //String commandStr = "ipconfig";
        Command.exeCmd(commandStr);
    }
}