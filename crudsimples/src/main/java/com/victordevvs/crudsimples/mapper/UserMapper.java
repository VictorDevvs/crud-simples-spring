package com.victordevvs.crudsimples.mapper;

import com.victordevvs.crudsimples.dto.UserRequestDto;
import com.victordevvs.crudsimples.dto.UserResponseDto;
import com.victordevvs.crudsimples.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toDto(User user);

    User toModel(UserRequestDto userRequestDto);
}
