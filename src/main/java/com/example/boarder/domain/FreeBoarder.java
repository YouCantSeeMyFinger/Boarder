package com.example.boarder.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 회원이 작성하는 글 도메인
 */

@Getter
@Setter
@ToString
public class FreeBoarder {
    private Integer boarder_number;
    private String title;
    private String author;
    private LocalDateTime created_table_date;
    private Integer view_count;
    private String post_content;
    private String membership_id;
}
