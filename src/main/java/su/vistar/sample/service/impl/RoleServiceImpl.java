package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.converters.impl.RoleConverter;
import su.vistar.sample.dao.impl.RoleDao;
import su.vistar.sample.dto.regular.RoleDto;
import su.vistar.sample.service.RoleService;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    private RoleConverter roleConverter;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, RoleConverter roleConverter) {
        this.roleDao = roleDao;
        this.roleConverter = roleConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDto> getAll() {
        return roleConverter.toDtos(roleDao.list());
    }

}
