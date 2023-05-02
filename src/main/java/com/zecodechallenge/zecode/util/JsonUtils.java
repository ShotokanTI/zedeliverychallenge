package com.zecodechallenge.zecode.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}