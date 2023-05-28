package com.example.boarder.member.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberValidationForm {
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "아이디는 알파벳과 숫자로 이루어진 1~10자여야 합니다.")
    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,20}$", message = "비밀번호는 대문자, 소문자, 숫자, 특수문자를 포함한 10~20자여야 합니다.")
    private String password;

    @NotBlank(message = "UserName을 입력해주세요.")
    @Pattern(regexp = "^(?!.*\\s)[a-zA-Z0-9]{1,10}$", message = "UserName은 알파벳과 숫자로 이루어진 1~10자여야 합니다.")
    private String userName;
}
