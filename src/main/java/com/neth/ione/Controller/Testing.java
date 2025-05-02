package com.neth.ione.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testing")
public class Testing {
    @RequestMapping
    public String test(){
        return "test";
    }
}
