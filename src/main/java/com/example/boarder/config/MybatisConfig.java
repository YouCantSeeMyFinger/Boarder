package com.example.boarder.config;


import com.example.boarder.boarder.freeboarder.mapper.IBoarderMapper;
import com.example.boarder.boarder.freeboarder.repository.BoarderRepoImpl;
import com.example.boarder.boarder.freeboarder.repository.IBoarderRepo;
import com.example.boarder.member.repository.IMemberRepository;
import com.example.boarder.member.mapper.MemberMapper;
import com.example.boarder.member.repository.MemberRepositoryImpl;
import com.example.boarder.member.repository.service.IMemberService;
import com.example.boarder.member.repository.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 2.2.0 버전에서 @MapperScan을 사용하려면  sqlSessionFactory를 사용하여 빈 주입을 해줘야한다.<br>
 * Mybatis 3.0.1 버전으로 수정
 */

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {

    private final MemberMapper memberMapper;
    private final IBoarderMapper iBoarderMapper;


    // 회원 Bean 주입 부분
    @Bean
    public IMemberRepository memberRepository() {
        return new MemberRepositoryImpl(this.memberMapper);
    }

    @Bean
    public IMemberService iMemberService() {
        return new MemberServiceImpl(this.memberRepository());
    }
    // 회원 Bean 주입 끝


    // Boarder Bean 주입 부분
    @Bean
    public IBoarderRepo iBoarderRepo() {
        return new BoarderRepoImpl(this.iBoarderMapper);
    }
    // Boarder Bean 주입 끝
}
