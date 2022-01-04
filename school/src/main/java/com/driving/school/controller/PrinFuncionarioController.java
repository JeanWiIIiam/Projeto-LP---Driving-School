package com.driving.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrinFuncionarioController {

    @GetMapping("/prinFuncionario")
    public String principal(Model Model){
        return "bemvindo";
    } 
    
}
