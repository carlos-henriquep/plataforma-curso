package com.henrique.curso.plataforma.api.service;

import com.henrique.curso.plataforma.api.mappers.UserConverter;
import com.henrique.curso.plataforma.api.model.dto.UserLoginDTO;
import com.henrique.curso.plataforma.api.model.dto.UserRegisterDTO;
import com.henrique.curso.plataforma.api.model.entity.UserEntity;
import com.henrique.curso.plataforma.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;


    public void register(UserRegisterDTO userRegisterDTO) throws Exception {
        if (isUserExists(userRegisterDTO.getEmail())) {
            throw new Exception("User already exists.");

        }
        UserEntity userToSave = userConverter.convertToUserEntityRegister(userRegisterDTO);
        userRepository.save(userToSave);
    };

    public void login(UserLoginDTO userLoginDTO)throws Exception{
        if(!isUserExists(userLoginDTO.getEmail())){
            throw new Exception("User doesn't exists.");
        }

        

    }


    public boolean isUserExists(String email) {
        Optional<UserEntity> isUserExists = userRepository.findByEmail(email);
        return isUserExists.isPresent();
    }
}
