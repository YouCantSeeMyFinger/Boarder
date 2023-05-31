package com.example.boarder.boarder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoarderController {

    @GetMapping("/freeBoarder")
    public String freeBoarder() {
        return "/boarder/freeBoarder";
    }
}
