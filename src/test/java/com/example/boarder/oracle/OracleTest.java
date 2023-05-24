package com.example.boarder.oracle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@Slf4j
@SpringBootTest
public class OracleTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Oracle Connection Test
     * @throws SQLException
     */

    @Test
    public void testConnection() throws SQLException {
        String sql = """
                select count(*) from test
                """;

        Integer count = this.jdbcTemplate.queryForObject(sql, Integer.class);
        log.info("count : {}", count);
    }
}


