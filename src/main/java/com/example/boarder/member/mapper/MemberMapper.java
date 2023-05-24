package com.example.boarder.member.mapper;


import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {


    void save(Member member);

    /**
     * 파라미터가 한 개인 경우 @Param 생략이 가능하지만 파라미터가 2개 이상이 경우에는 @Param 기입
     *
     * @param memberDTO
     * @param id
     */
    void update(@Param("memberDTO") MemberDTO memberDTO, @Param("id") String id);

    Optional<Member> findById(String id);
}
