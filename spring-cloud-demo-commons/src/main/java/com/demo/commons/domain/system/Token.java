package com.demo.commons.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {

    private String token;
    private Long exp;
    private String refreshToken;
    private User user;

}
