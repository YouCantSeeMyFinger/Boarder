package com.example.boarder.domain;


import lombok.*;
import java.time.LocalDateTime;

/**
 * 회원이 작성하는 글 도메인
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FreeBoarder {
    private String boarder_number;
    private String title;
    private String author;
    private LocalDateTime created_table_date;
    private Integer view_count;
    private String post_content;
    private String membership_id;

    public FreeBoarder(String title, String author, LocalDateTime created_table_date, Integer view_count, String post_content, String membership_id) {
        this.title = title;
        this.author = author;
        this.post_content = post_content;
        this.membership_id = membership_id;
        this.created_table_date = created_table_date;
        this.view_count = view_count;
    }
}
