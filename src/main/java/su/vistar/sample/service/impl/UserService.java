package su.vistar.sample.service.impl;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.dao.impl.UserDao;
import su.vistar.sample.domain.User;
import su.vistar.sample.dto.UserDto;
import su.vistar.sample.service.IService;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserService implements IService<UserDto, Integer> {

    private final UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public Integer save(UserDto object) {
        return dao.save(new User(object));
    }

    public UserDto find(Integer id) {
        return new UserDto(dao.find(id));
    }

    public void update(UserDto object) {
        dao.update(new User(object));
    }

    public void delete(UserDto object) {
        dao.delete(new User(object));
    }

    public List<UserDto> findAll() {
        List<User> users = dao.list();
        List<UserDto> usersDto = new ArrayList<UserDto>();
        for (User user : users) {
            usersDto.add(new UserDto(user));
        }
        return usersDto;
    }

    public UserDto getUserByEmail(String email) {
        User user = dao.findByEmail(email);
        return new UserDto(user);
    }
}
