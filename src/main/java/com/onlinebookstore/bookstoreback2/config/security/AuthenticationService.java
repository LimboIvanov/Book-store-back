package com.onlinebookstore.bookstoreback2.config.security;

import com.onlinebookstore.bookstoreback2.dto.UserDto;
import com.onlinebookstore.bookstoreback2.mapper.UserMapper;
import com.onlinebookstore.bookstoreback2.model.User;
import com.onlinebookstore.bookstoreback2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("START authenticate  " + request.getPassword());
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
            )
        );
        var user = repository.findUserByUsername(request.getUsername())
                .orElseThrow();
        System.out.println("USER  " + user);
        var jwtToken = jwtService.generateToken(user);
        System.out.println("TOKEN  " + jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public User getCurrentUserAsEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    public UserDto getCurrentUserAsDto() {
        User user = getCurrentUserAsEntity();
        return userMapper.toDto(user);
    }
}
