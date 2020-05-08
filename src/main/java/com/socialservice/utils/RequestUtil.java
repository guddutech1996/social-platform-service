package com.socialservice.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class RequestUtil {

    public String getHeader(String headerName) {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest().getHeader(headerName);
    }
}
