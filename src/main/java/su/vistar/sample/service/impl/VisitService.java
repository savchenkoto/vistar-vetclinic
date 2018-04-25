package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.sample.dao.impl.VisitDao;
import su.vistar.sample.domain.User;
import su.vistar.sample.domain.Visit;
import su.vistar.sample.dto.UserDto;
import su.vistar.sample.dto.VisitDto;
import su.vistar.sample.service.IService;

import java.util.ArrayList;
import java.util.List;

@Service("visitService")
public class VisitService implements IService<VisitDto, Integer> {

    private final VisitDao dao;

    @Autowired
    public VisitService(VisitDao visitDao) {
        this.dao = visitDao;
    }


    public Integer save(VisitDto object) {
        return dao.save(new Visit(object));
    }

    public VisitDto find(Integer id) {
        return new VisitDto(dao.find(id));
    }

    public void update(VisitDto object) {
        dao.update(new Visit(object));
    }

    public void delete(VisitDto object) {
        dao.delete(new Visit(object));
    }

    public List<VisitDto> findAll() {
        List<Visit> visits = dao.list();
        List<VisitDto> visitDtos = new ArrayList<VisitDto>();
        for (Visit visit : visits) {
            visitDtos.add(new VisitDto(visit));
        }
        return visitDtos;
    }

    public List<VisitDto> findByUserId(Integer userId) {
        List<Visit> visits = dao.findByUserId(userId);
        List<VisitDto> visitDtos = new ArrayList<VisitDto>();
        for (Visit visit : visits) {
            visitDtos.add(new VisitDto(visit));
        }
        return visitDtos;
    }


}
