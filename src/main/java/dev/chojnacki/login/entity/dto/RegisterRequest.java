package dev.chojnacki.login.entity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private Set<String> roles;
}
