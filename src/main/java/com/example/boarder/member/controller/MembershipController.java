package com.example.boarder.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembershipController {


    @GetMapping("/membership")
    public String membership() {
        return "/membership/membership";
    }
}
