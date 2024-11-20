package com.spring.Banking.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    public JwtResponse(String jwtToken, String message, Boolean success, String email, String role) {
        this.jwtToken = jwtToken;
        this.message = message;
        this.success = success;
        this.email = email;
        this.role = role;
    }

    private String jwtToken;
    private String message;
    private Boolean success;
    private String email;
    private String role;
}