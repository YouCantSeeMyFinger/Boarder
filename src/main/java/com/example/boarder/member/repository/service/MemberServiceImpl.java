package com.example.boarder.member.repository.service;

import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;
import com.example.boarder.member.repository.IMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements IMemberService {

    private final IMemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return this.memberRepository.save(member);
    }

    @Override
    public void update(MemberDTO memberDTO, String id) {
        this.memberRepository.update(memberDTO, id);
    }

    @Override
    public Optional<Member> findByMember(String id) {
        return this.memberRepository.findByMember(id);
    }

    @Override
    public Optional<Member> loginMember(String id, String password) {
        log.info("loginMember :: invoked");
        Optional<Member> foundMember = this.memberRepository.findByMember(id);

        if (foundMember.isPresent()) {
            Member member = foundMember.get();
            // 아이디와 패스워드가 동일하다면 다시 member 객체를 반환
            // 그 외에는 Optional.empty 반환한다.
            if (member.getId().equals(id) && member.getPassword().equals(password)) {
                log.info("로그인 성공");
                return Optional.of(member);
            } else {
                log.info("입력정보가 맞지 않아 로그인 실패");
                return Optional.empty();
            }
        } else {
            log.info("해당 회원은 존재하지 않는다.");
            return Optional.empty();
        }
    }
}
