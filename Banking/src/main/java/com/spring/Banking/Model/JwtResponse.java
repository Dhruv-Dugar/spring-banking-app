package com.spring.Banking.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {

    private String jwtToken;
    private String message;
    private Boolean success;
    private String email;
    private String role;
}