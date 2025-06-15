package dev.chojnacki.login.services;

import dev.chojnacki.login.entity.User;
import dev.chojnacki.login.entity.dto.RegisterRequest;

public interface UserService {
    User findByUsername(String username);
    User registerUser(RegisterRequest registerRequest);
}
