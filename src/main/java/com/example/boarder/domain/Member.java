package com.example.boarder.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Member Domain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String id;
    private String password;
    private String userName;
}
