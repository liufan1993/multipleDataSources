package com.liufan.mutildatasource.controller;

import com.liufan.mutildatasource.service.impl.CeshiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.CEStreamExhausted;

/**
 * @author insistOn
 * @Title:
 * @Package
 * @Description:
 * @date 2020/3/2518:37
 */
@RestController
public class CeshiController {

    @Autowired
    private CeshiServiceImpl ceshiService;

    @RequestMapping("ceshi")
    public void ceshi(){
        ceshiService.ceshi();
    }
}
