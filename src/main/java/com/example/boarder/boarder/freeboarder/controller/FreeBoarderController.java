package com.example.boarder.boarder.freeboarder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FreeBoarderController {

    @GetMapping("/freeBoarder")
    public String freeBoarder() {
        return "/freeboarder/freeBoarder";
    }


    // TODO 아래의 메소드는 검색 기능을 구현하기 위해 만들어놓은 메소드
    @PostMapping("/freeBoarder-filter")
    public String freeBoarder_filter() {
        return "/freeboarder/freeBoarder";
    }


    @GetMapping("/freeboarder/write_boarder")
    public String write_boarder() {
        return "/freeboarder/write";
    }
}
