package com.henrique.curso.plataforma.api.mappers;

import com.henrique.curso.plataforma.api.model.dto.UserRegisterDTO;
import com.henrique.curso.plataforma.api.model.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

   private final ModelMapper modelMapper = new ModelMapper();

   public UserEntity convertToUserEntityRegister(UserRegisterDTO userRegisterDTO){
       return modelMapper.map(userRegisterDTO, UserEntity.class);
   }
}
