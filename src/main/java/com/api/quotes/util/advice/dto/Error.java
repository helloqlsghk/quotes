package com.api.quotes.util.advice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {

    private String message;

    private String key;

    private Object value;

    private String status;

}