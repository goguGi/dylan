package com.dylan.girl.controller;

import com.dylan.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = "hello")
    public String say(@RequestParam(value = "id" , required = false, defaultValue = "999") Integer id){
        return girlProperties.getCupSize() + ",id" + id;
    }
}
