package com.example.boarder.member.service;

import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;

import java.util.Optional;


public interface IMemberService {
    Member save(Member member);

    void update(MemberDTO memberDTO, String id);

    Optional<Member> findByMember(String id);


}
