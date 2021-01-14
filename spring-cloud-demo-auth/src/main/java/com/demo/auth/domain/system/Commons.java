package com.demo.auth.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commons {

    /**
     * 加盐
     */
    public static final String SECRET = "demo";

    private static final String REFRESH_TOKEN_SECRET = "";

}
