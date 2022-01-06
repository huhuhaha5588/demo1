package com.dev.demo1.api;

import com.dev.demo1.service.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.office.OfficeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * 格式转换
 */
@RestController
//@Controller
@Path("/template1")
@Slf4j
public class Convert {

    @Autowired
    private ConverterService ConverterService;

    /**
     * 测试contrllor
     * @return
     */
    @GET
    @Path("text")
    public String htmlToPPT() throws OfficeException {
        try {
//            ConverterService.html2pdf();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
