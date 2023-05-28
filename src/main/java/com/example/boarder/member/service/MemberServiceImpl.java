package com.example.boarder.member.service;

import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;
import com.example.boarder.member.repository.IMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
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

}
