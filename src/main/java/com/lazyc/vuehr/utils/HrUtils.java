package com.lazyc.vuehr.utils;

import com.lazyc.vuehr.pojo.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {
    public static Hr getCurrentHr() {
       return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
