package com.example.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author
 * @create 2021 - 03 - 03 下午 12:00
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenPayload {

    private String company;
    private long timeStamp;

    public boolean isValid(long limit){
        return (new Date().getTime()/1000 - timeStamp) < limit;
    }

    public static String toJson(String company) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(new TokenPayload(company,new Date().getTime()/1000));
    }

    public static String toJson(String company, long timeStamp) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(new TokenPayload(company, timeStamp));
    }

    public static TokenPayload parseJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, TokenPayload.class);
    }

}
