package com.example.boarder.member.controller;

import com.example.boarder.domain.Member;
import com.example.boarder.member.service.IMemberService;
import com.example.boarder.member.validation.CheckDuplicateIdValidation;
import com.example.boarder.member.validation.MemberValidationForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MembershipController {

    private final IMemberService iMemberService;
    private final CheckDuplicateIdValidation checkDuplicateIdValidation;

    @GetMapping("/membership")
    public String membership(@ModelAttribute("memberform") MemberValidationForm memberValidationForm) {
        return "/membership/membership";
    }

    @PostMapping("/membership")
    public String membershipForm(@Valid @ModelAttribute("memberform") MemberValidationForm memberValidationForm,
                                 BindingResult bindingResult) {
        // 중복검사 적용
        this.checkDuplicateIdValidation.validate(memberValidationForm, bindingResult);

        // 검증 실패시 입력폼으로 다시 이동
        if (bindingResult.hasErrors()) {
            log.info("errors : {}", bindingResult);
            return "/membership/membership";
        }

        // 성공하면 home 이동
        Member member = new Member(memberValidationForm.getId(), memberValidationForm.getPassword(), memberValidationForm.getUsername());
        Member save = this.iMemberService.save(member);
        return "redirect:/";
    }
}
