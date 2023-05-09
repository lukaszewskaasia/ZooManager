package pl.coderslab.zoomanager.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }

    public AnimalDto createAnimal(AnimalDto animalDto) {
        Animal animal = animalMapper.fromDto(animalDto);
        Animal savedAnimal = animalRepository.save(animal);
        return animalMapper.toDto(savedAnimal);
    }

    public AnimalDto getAnimal(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal with id " + id + " not found"));
        return animalMapper.toDto(animal);
    }

    public List<AnimalDto> getAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return animals.stream()
                .map(animalMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateAnimal(Long id, AnimalDto animalDto) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal with id " + id + " not found"));
        animal.setSpecies(animalDto.getSpecies());
        animal.setHealthCard(animalDto.getHealthCard());
        animal.setKeepers(animalDto.getKeepers());
        animal.setName(animalDto.getName());
        animal.setAdoptDate(animalDto.getAdoptDate());
        animal.setDescription(animalDto.getDescription());
        animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
