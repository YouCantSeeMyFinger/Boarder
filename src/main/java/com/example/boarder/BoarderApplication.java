package com.example.boarder;

import com.example.boarder.config.MybatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(MybatisConfig.class)
@SpringBootApplication
public class BoarderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoarderApplication.class, args);
    }

}
