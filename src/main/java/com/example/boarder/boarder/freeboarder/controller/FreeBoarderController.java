package com.example.boarder.boarder.freeboarder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FreeBoarderController {

    @GetMapping("/freeBoarder")
    public String freeBoarder() {
        return "/boarder/freeBoarder";
    }

    @PostMapping("/freeBoarder-filter")
    public String freeBoarder_filter() {
        return "/boarder/freeBoarder";
    }
}
