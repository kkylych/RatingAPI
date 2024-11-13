package com.courseWork.RatingAPI.mappers;

import com.courseWork.RatingAPI.DTOs.UserDTO;
import com.courseWork.RatingAPI.entities.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail());
    }

    public static UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.id());
        userEntity.setFirstName(userDTO.firstName());
        userEntity.setLastName(userDTO.lastName());
        userEntity.setEmail(userDTO.email());
        return userEntity;
    }
}

