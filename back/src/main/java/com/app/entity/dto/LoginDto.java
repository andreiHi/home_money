package com.app.entity.dto;

import com.app.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginDto {

    private Long id;
    private String email;
    private String password;
    private Boolean rememberMe;

    public static LoginDto getFromUser(Users users) {
        return LoginDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .build();
    }
}
