package su.vistar.sample.service.impl;

import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.sample.converters.impl.AnimalConverter;
import su.vistar.sample.dao.impl.AnimalDao;
import su.vistar.sample.dto.regular.AnimalDto;
import su.vistar.sample.service.AnimalService;

import java.util.List;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private final AnimalDao animalDao;

    private final AnimalConverter animalConverter;

    public AnimalServiceImpl(AnimalDao animalDao, AnimalConverter animalConverter) {
        this.animalDao = animalDao;
        this.animalConverter = animalConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalDto> getAll() {
        return animalConverter.toDtos(animalDao.list());
    }

    @Override
    @Transactional
    public void save(AnimalDto animalDto) throws AlreadyExistsException {
        List animals = animalDao.findByType(animalDto.getType());
        if (animals == null || animals.isEmpty()) {
            animalDao.saveOrUpdate(animalConverter.toEntity(animalDto));
        } else {
            throw new AlreadyExistsException("This kind is already exist.");
        }
    }

    @Override
    @Transactional
    public void update(AnimalDto animalDto) {
        animalDao.update(animalConverter.toEntity(animalDto));
    }

    @Override
    @Transactional(readOnly = true)
    public AnimalDto getById(Integer id) {
        return animalConverter.toDto(animalDao.find(id));
    }
}
