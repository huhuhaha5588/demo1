package com.dev.demo1.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Command {
    public static void exeCmd(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        String commandStr = "soffice --infilter=\"impress_pdf_import\" --convert-to ppt --outdir /Users/johnzhang/testconvertor/ppt /Users/johnzhang/testconvertor/pdf/test.pdf";
        //String commandStr = "ipconfig";
        Command.exeCmd(commandStr);
    }
}
