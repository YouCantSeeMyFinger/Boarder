package com.example.boarder.config;


import com.example.boarder.member.repository.IMemberRepository;
import com.example.boarder.member.repository.MemberMapper;
import com.example.boarder.member.repository.MemberRepositoryImpl;
import com.example.boarder.member.service.IMemberService;
import com.example.boarder.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {

    private final MemberMapper memberMapper;

    @Bean
    public IMemberRepository memberRepository() {
        return new MemberRepositoryImpl(this.memberMapper);
    }

    @Bean
    public IMemberService iMemberService() {
        return new MemberServiceImpl(this.memberRepository());
    }
}
