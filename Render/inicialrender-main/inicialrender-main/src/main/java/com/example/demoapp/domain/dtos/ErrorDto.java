package com.example.demoapp.domain.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private String errorMsg;
    private String errorClass;
}
