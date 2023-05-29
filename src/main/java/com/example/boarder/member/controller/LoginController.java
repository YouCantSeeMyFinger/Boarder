package com.example.boarder.member.controller;


import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.LoginForm;
import com.example.boarder.member.service.IMemberService;
import com.example.boarder.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String loginService(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
                               BindingResult bindingResult,
                               HttpServletRequest request) {

        // FORM 입력형식에 맞지 않을 때
        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Optional<Member> foundMember = this.iMemberService.loginMember(loginForm.getId(), loginForm.getPassword());

        // 서비스 로직에 의해서 회원가입하지 않은 회원 또는 회원이지만 클라이언트가 입력한 정보가 틀렸을 경우 isEmpty
        if (foundMember.isEmpty()) {
            bindingResult.reject("login fail", "아이디 혹은 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, foundMember.get());
        return "redirect:/";
    }
}
