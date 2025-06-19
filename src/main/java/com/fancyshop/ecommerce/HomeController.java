package com.fancyshop.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// telling this is a controller class
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
    
}
