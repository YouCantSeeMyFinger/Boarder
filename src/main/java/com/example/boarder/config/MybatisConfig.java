package com.example.boarder.config;


import com.example.boarder.member.repository.IMemberRepository;
import com.example.boarder.member.mapper.MemberMapper;
import com.example.boarder.member.repository.MemberRepositoryImpl;
import com.example.boarder.member.service.IMemberService;
import com.example.boarder.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 2.2.0 버전에서 @MapperScan을 사용하려면  sqlSessionFactory를 사용하여 빈 주입을 해줘야한다.
 */

@Configuration
@RequiredArgsConstructor
//@MapperScan(value = "com.example.boarder.member.mapper")
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
