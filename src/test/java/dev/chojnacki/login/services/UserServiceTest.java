package dev.chojnacki.login.services;

import dev.chojnacki.login.entity.User;
import dev.chojnacki.login.entity.dto.RegisterRequest;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    private final UserService userService;

    @Autowired
    UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void createAccountTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setRoles(Set.of("ROLE_USER"));

        User user = userService.registerUser(registerRequest);

        assertNotNull(user);
        assertEquals("username", user.getUsername());

        assertEquals(user, userService.findByUsername("username"));
    }

}