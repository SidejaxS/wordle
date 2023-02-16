package com.javierburillo.javierburillo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javierburillo.javierburillo.models.PalabraPorLetras;
import com.javierburillo.javierburillo.services.IPalabraService;

@Controller
public class PalabraController {

    @Autowired
    IPalabraService service;

    @GetMapping("/")
    public ModelAndView checkword1() {
        ModelAndView modelAndView = new ModelAndView("wordle");
        modelAndView.addObject("Attempts", service.getAttempts());
        return modelAndView;
    }

    

    @PostMapping("/check")
    public ModelAndView checkword(String word) {
        List<PalabraPorLetras> list = service.check(word);
        List<String> history = service.getBefore();
        boolean ganar = false;
        if (list != null) {
            for (PalabraPorLetras letra : list) {
                if (letra.isCorrecto() && letra.getposicion() == letra.getposicionCorrecta()) {
                    ganar = true;
                } else {
                    ganar = false;
                    break;
                }
            }
        }
        ModelAndView modelAndView;
        if (ganar) {
            modelAndView = new ModelAndView("resultado");
        } else {
            modelAndView = new ModelAndView("wordle");
        }
        modelAndView.addObject("word", list);
        modelAndView.addObject("history", history);
        modelAndView.addObject("Attempts", service.getAttempts());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView checkword(int number) {
        String word = service.getWordByPos(number);
        if (word == null) {
            word = "Introduzca una palabra válida";
        }
        ModelAndView modelAndView = new ModelAndView("resultado");
        modelAndView.addObject("pos", number);
        modelAndView.addObject("word", word);
        modelAndView.addObject("Attempts", service.getAttempts());
        return modelAndView;
    }

}
