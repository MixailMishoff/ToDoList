package com.Todo.ToDoList.service;

import com.Todo.ToDoList.dto.UserDTO;
import com.Todo.ToDoList.model.User;
import com.Todo.ToDoList.model.UserDetails.UserDetailsInfoHeader;
import com.Todo.ToDoList.model.UserDetails.UserDetailsInfoPayload;
import com.Todo.ToDoList.repository.UserRepository;
import com.Todo.ToDoList.security.JWTService;
import com.Todo.ToDoList.model.UserDetails.UserDetailsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tools.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Base64;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(UserDTO userdto) {

        User user = User.builder()
                .email(userdto.getEmail())
                .password(userdto.getPassword())
                .build();

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        return jwtService.generateToken(user.getEmail());
    }


    public UserDetailsInfo login(UserDTO loginCred) {
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(loginCred.getEmail(), loginCred.getPassword());


            authenticationManager.authenticate(authInputToken);

            String token = jwtService.generateToken(loginCred.getEmail());


            String[] chunks = token.split("\\.");

            Base64.Decoder decoder = Base64.getUrlDecoder();

            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));


            return new UserDetailsInfo(
                    new ObjectMapper().readValue(header, UserDetailsInfoHeader.class),
                    new ObjectMapper().readValue(payload, UserDetailsInfoPayload.class),
                    token);
        } catch (AuthenticationException authExc) {
            authExc.printStackTrace(); // Добавьте это!
            throw new RuntimeException("Invalid Login Credentials");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserInfo() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(email);
    }
}
