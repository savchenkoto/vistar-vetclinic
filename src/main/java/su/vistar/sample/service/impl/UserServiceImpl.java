package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import su.vistar.sample.domain.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.converters.impl.ProfileConverter;
import su.vistar.sample.converters.impl.UserConverter;
import su.vistar.sample.dao.impl.UserDao;
import su.vistar.sample.dao.impl.VisitDao;
import su.vistar.sample.domain.VisitEntity;
import su.vistar.sample.dto.ProfileInfoDto;
import su.vistar.sample.dto.regular.UserDto;
import su.vistar.sample.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserConverter userConverter;

    private UserDao userDao;

    private VisitDao visitDao;

    private ProfileConverter profileConverter;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, VisitDao visitDao,
                           UserConverter userConverter, ProfileConverter profileConverter) {
        this.userDao = userDao;
        this.visitDao = visitDao;
        this.userConverter = userConverter;
        this.profileConverter = profileConverter;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Integer save(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userDao.findByEmail(userDto.getEmail()) != null) {
            return null;
        }
        return userDao.save(userConverter.toEntity(userDto));
    }

    public boolean Exist(String email) {
        boolean result = false;
        if (userDao.findByEmail(email) != null) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public void update(UserDto userDto) {
        userDao.update(userConverter.toEntity(userDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userConverter.toDtos(userDao.list());
    }


    @Override
    @Transactional(readOnly = true)
    public UserDto getUserByEmail(String email) {
        return userConverter.toDto(userDao.findByEmail(email));
    }

    @Override
    @Transactional(readOnly = true)
    public ProfileInfoDto getProfileByEmail(String email) {
        UserEntity user = userDao.findByEmail(email);
        VisitEntity lastVisit = visitDao.getLastVisitByUserId(email);
        return profileConverter.toDto(user, lastVisit);
    }


}
