package com.example.boarder.member.controller;


import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.LoginForm;
import com.example.boarder.member.service.IMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final IMemberService iMemberService;

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm) {
        return "/login/login";
    }

    @PostMapping("/login")
    public String loginService(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {

        // 입력형식에 맞지 않을 때
        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Optional<Member> foundMember = this.iMemberService.findByMember(loginForm.getId());

        // 회원가입하지 않은 회원일때
        if (foundMember.isEmpty()) {
            bindingResult.reject("login fail", "아이디 혹은 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        // TODO
        // 회원가입한 회원이 로그인 신청했을 때 세션을 생성 후 처리해주는 과정


        return "/login/login";
    }
}
