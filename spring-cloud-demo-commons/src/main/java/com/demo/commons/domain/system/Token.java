package com.demo.commons.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    private String token;
    private Long exp;
    private String refreshToken;
    private User user;

}
