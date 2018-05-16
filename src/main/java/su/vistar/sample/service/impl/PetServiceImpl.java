package su.vistar.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.converters.impl.PetConverter;
import su.vistar.sample.dao.impl.PetDao;
import su.vistar.sample.dto.regular.PetDto;
import su.vistar.sample.service.PetService;

import java.util.List;

@Service("petService")
public class PetServiceImpl implements PetService {

    private PetDao petDao;

    private PetConverter petConverter;

    @Autowired
    public PetServiceImpl(PetDao petDao, PetConverter petConverter) {
        this.petDao = petDao;
        this.petConverter = petConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetDto> getAll() {
        return petConverter.toDtos(petDao.list());
    }

}
