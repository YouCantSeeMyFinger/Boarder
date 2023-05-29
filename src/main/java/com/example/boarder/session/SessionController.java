package com.example.boarder.session;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class SessionController {
    /**
     * value가 어떤 객체가 들어있는지 불확실 떄문에 Object 반환<br><br>
     * 문제점 : session을 조회하면 암호화 되지 않는 비밀번호가 보인다.
     *
     * @param session
     * @return Object
     */
    @GetMapping("/get-session")
    public Object getSession(HttpSession session) {
        return session.getAttribute(SessionConst.LOGIN_MEMBER);
    }

}
