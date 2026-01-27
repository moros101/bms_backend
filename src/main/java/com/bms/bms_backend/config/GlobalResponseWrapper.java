package com.bms.bms_backend.config;

import com.bms.bms_backend.dto.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;

//@ControllerAdvice
@RestControllerAdvice // Automatically serializes to JSON -  No need for @ResponseBody
public class GlobalResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.getParameterType().equals(ApiResponse.class)
            && !returnType.getParameterType().getSimpleName().equals("ErrorResponse");
    }

    @Override
    public Object beforeBodyWrite(
            Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {

        if(body instanceof ApiResponse<?>)
            return body;

        return ApiResponse.builder()
                .status("SUCCESS")
                .message("Request processed successfully")
                .data(body)
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
