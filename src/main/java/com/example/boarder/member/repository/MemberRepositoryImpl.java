package com.example.boarder.member.repository;


import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;
import com.example.boarder.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements IMemberRepository {

    /**
     * Mybatis 이용을 위해 memberMapper 필요하다.<br>
     */
    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        this.memberMapper.save(member);
        return member;
    }

    @Override
    public void update(MemberDTO memberDTO, String id) {
        this.memberMapper.update(memberDTO, id);
    }

    @Override
    public void delete(String id) {
        this.memberMapper.delete(id);
    }

    @Override
    public Optional<Member> findByMember(String id) {
        return this.memberMapper.findById(id);
    }

    @Override
    public int checkDuplicatedId(String id) {
        return this.memberMapper.checkDuplicatedId(id);
    }

}
