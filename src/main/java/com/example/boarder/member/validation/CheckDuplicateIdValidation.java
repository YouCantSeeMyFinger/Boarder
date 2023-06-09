package com.example.boarder.member.validation;

import com.example.boarder.member.repository.IMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CheckDuplicateIdValidation implements Validator {

    private final IMemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberValidationForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberValidationForm target1 = (MemberValidationForm) target;
        if (this.memberRepository.checkDuplicatedId(target1.getId()) >= 1) {
            errors.rejectValue("id", "duplicated id", new Object[]{target1.getId()}, "사용중인 아이디입니다.");
        }
    }
}
