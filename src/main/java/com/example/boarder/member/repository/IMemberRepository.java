package com.example.boarder.member.repository;

import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;

import java.util.Optional;

public interface IMemberRepository {

    /**
     * 회원 저장
     *
     * @param member
     * @return
     */
    Member save(Member member);


    /**
     * 회원 업데이트
     *
     * @param memberDTO
     * @param id
     */
    void update(MemberDTO memberDTO, String id);

    /**
     * 회원삭제
     *
     * @param id
     */

    void delete(String id);

    /**
     * 회원 업데이트
     *
     * @param id
     * @return Optional
     */

    Optional<Member> findByMember(String id);

    int checkDuplicatedId(String id);
}
