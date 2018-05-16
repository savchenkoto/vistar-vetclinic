package su.vistar.sample.service;

import su.vistar.sample.dto.regular.AnimalDto;

import java.util.List;

public interface AnimalService {

    AnimalDto getById(Integer id);

    List<AnimalDto> getAll();

    void save(AnimalDto animalDto);

    void update(AnimalDto animalDto);

}
