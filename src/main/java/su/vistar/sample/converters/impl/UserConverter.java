package su.vistar.sample.converters.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import su.vistar.sample.domain.UserEntity;
import su.vistar.sample.dto.regular.UserDto;

@Component("userConverter")
public class UserConverter extends AbstractConverter<UserEntity, UserDto> {

    public UserConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

//    @Override
//    public UserEntity toEntity(UserDto userDto) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setEmail(userDto.getEmail());
//        userEntity.setPassword(userDto.getPassword());
//        userEntity.setFirstName(userDto.getFirstName());
//        userEntity.setLastName(userDto.getLastName());
//        userDto.
//    }

}
