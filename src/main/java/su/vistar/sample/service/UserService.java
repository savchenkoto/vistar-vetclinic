package su.vistar.sample.service;

import su.vistar.sample.dto.ProfileInfoDto;
import su.vistar.sample.dto.regular.UserDto;

import java.util.List;


public interface UserService {

    Integer save(UserDto userDto);

    void update(UserDto userDto);

    List<UserDto> getAll();

    UserDto getUserByEmail(String email);

    ProfileInfoDto getProfileByEmail(String email);


}
