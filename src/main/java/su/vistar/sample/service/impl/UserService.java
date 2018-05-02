package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.converters.impl.ProfileConverter;
import su.vistar.sample.converters.impl.UserConverter;
import su.vistar.sample.converters.impl.VisitConverter;
import su.vistar.sample.converters.impl.VisitPreviewConverter;
import su.vistar.sample.dao.impl.AbstractDao;
import su.vistar.sample.dao.impl.UserDao;
import su.vistar.sample.dao.impl.VisitDao;
import su.vistar.sample.domain.UserEntity;
import su.vistar.sample.domain.VisitEntity;
import su.vistar.sample.dto.VisitPreviewDto;
import su.vistar.sample.dto.regular.UserDto;
import su.vistar.sample.dto.ProfileInfoDto;
import su.vistar.sample.dto.regular.VisitDto;

import javax.persistence.criteria.CriteriaBuilder;


@Service("userService")
@Transactional
public class UserService extends AbstractService<UserEntity, UserDto, Integer> {

    private UserDao userDao;

    private VisitDao visitDao;

    private final UserConverter userConverter;

    private final ProfileConverter profileConverter;

    @Autowired
    public UserService(@Qualifier("userDao") AbstractDao<UserEntity, Integer> userDao,
                       AbstractDao<VisitEntity, Integer> visitDao,
                       UserConverter userConverter,
                       VisitPreviewConverter visitPreviewConverter,
                       ProfileConverter profileConverter) {
        super(userDao, userConverter);
        this.userDao = (UserDao) userDao;
        this.visitDao = (VisitDao) visitDao;
        this.userConverter = userConverter;
        this.profileConverter = profileConverter;
    }

    public UserDto getUserByEmail(String email) {
        return userConverter.toDto(userDao.findByEmail(email));
    }

    public ProfileInfoDto getProfileByEmail(String email) {
        UserEntity user = userDao.findByEmail(email);
        VisitEntity lastVisit = visitDao.getLastVisitByUserId(email);
        return profileConverter.toDto(user, lastVisit);
    }

}
