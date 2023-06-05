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
    private String post_content;
    private String membership_id;

    public FreeBoarder(String title, String author, String post_content, String membership_id) {
        this.title = title;
        this.author = author;
        this.post_content = post_content;
        this.membership_id = membership_id;
    }
}
