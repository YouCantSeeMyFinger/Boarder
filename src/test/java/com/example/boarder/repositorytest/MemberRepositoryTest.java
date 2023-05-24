package com.example.boarder.repositorytest;


import com.example.boarder.domain.Member;
import com.example.boarder.member.dto.MemberDTO;
import com.example.boarder.member.repository.IMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


/**
 * Test에서의 Transcational 어노테이션은 테스트 메소드가 하나 실행되고 롤백된다.
 */

@Slf4j
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    IMemberRepository memberRepository;

    /**
     * Save Test
     */

    @Test
    public void save() {
        Member member1 = new Member("TEST02", "PASSWORD02", "이동영");
        Member member2 = new Member("TEST03", "PASSWORD03", "이예림");
        Member member3 = new Member("TEST04", "PASSWORD04", "고찬솔");
        this.memberRepository.save(member1);
        this.memberRepository.save(member2);
        this.memberRepository.save(member3);
    }

    /**
     * findById Test
     */

    @Test
    public void findById() {
        Optional<Member> test = this.memberRepository.findByMember("TEST01");
        test.stream().forEach(member -> {
            assertThat(member.getId()).isEqualTo("TEST01");
        });
    }

    @Test
    public void delete() {
        Optional<Member> test = this.memberRepository.findByMember("TEST01");
        test.stream().forEach(member -> {
            this.memberRepository.delete(member.getId());
        });
    }

    @Test
    public void update() {
        Optional<Member> test01 = this.memberRepository.findByMember("TEST01");
        if (test01.isPresent()) {
            Member member = test01.get();
            MemberDTO memberDTO = new MemberDTO("TEST02", "1234");
            this.memberRepository.update(memberDTO, member.getId());
        }
        this.memberRepository.findByMember("TEST02");
    }
}
