package com.dev.demo1.api;

import com.dev.demo1.service.ConverterService;
import org.jodconverter.core.office.OfficeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 格式转换
 */
@RestController
public class Convert {

    @Autowired
    private ConverterService ConverterService;

    /**
     * 测试contrllor
     * @return
     */
    @GetMapping("html2ppt")
    public String htmlToPPT() throws OfficeException {
        try {
//            ConverterService.html2pdf();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "done";
    }
}
