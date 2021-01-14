package com.demo.auth.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateUtils {

    public SimpleDateFormat dateFormat;

    /**
     * 获取当前时间字符串
     * @return
     */
    public String nowTime(){
        dateFormat.applyPattern("yyyyMMddhhmmss");
        return dateFormat.format(System.currentTimeMillis());
    }

}
