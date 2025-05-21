package com.victordevvs.crudsimples.mapper;

import com.victordevvs.crudsimples.dto.UserRequestDto;
import com.victordevvs.crudsimples.dto.UserResponseDto;
import com.victordevvs.crudsimples.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T10:29:08-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( user.getId() );
        userResponseDto.setName( user.getName() );
        userResponseDto.setEmail( user.getEmail() );
        userResponseDto.setBirthDate( user.getBirthDate() );

        return userResponseDto;
    }

    @Override
    public User toModel(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userRequestDto.getId() );
        user.setName( userRequestDto.getName() );
        user.setEmail( userRequestDto.getEmail() );
        user.setBirthDate( userRequestDto.getBirthDate() );
        user.setPassword( userRequestDto.getPassword() );

        return user;
    }
}
