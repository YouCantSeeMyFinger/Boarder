package com.example.boarder.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BoarderDTO {
    private String title;
    private String post_content;


    public BoarderDTO(String title, String post_content) {
        this.title = title;
        this.post_content = post_content;
    }
}
