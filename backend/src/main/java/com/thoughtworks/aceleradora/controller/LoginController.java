package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.service.util.JwtUtil;
import com.thoughtworks.aceleradora.controller.response.LoginResponse;
import com.thoughtworks.aceleradora.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.ws.rs.POST;

@RestController
@RequestMapping("/login")

public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public String returnAPI(@RequestBody User user) {

        LoginResponse login = new LoginResponse();

        String data = login.returnLogin(user.getUser(), user.getPassword());
        return data;

    }

    @PostMapping("/testeJWT")
    public String generateToken(@RequestBody User user) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUser(), user.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return JwtUtil.generateToken(user.getUser());
    }

}


