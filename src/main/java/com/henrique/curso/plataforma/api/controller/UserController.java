package com.henrique.curso.plataforma.api.controller;

import com.henrique.curso.plataforma.api.model.dto.UserRegisterDTO;
import com.henrique.curso.plataforma.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<String> register(@RequestBody UserRegisterDTO userRegisterDTO){
        try {
            userService.register(userRegisterDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário criado com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
