package pl.coderslab.zoomanager.HealthCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pl.coderslab.zoomanager.animal.Animal;
import pl.coderslab.zoomanager.animal.AnimalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthCardService {

    private final HealthCardRepository healthCardRepository;
    private final HealthCardMapper healthCardMapper;
    private final AnimalRepository animalRepository;

    @Autowired
    public HealthCardService(HealthCardRepository healthCardRepository, HealthCardMapper healthCardMapper,
                             AnimalRepository animalRepository) {
        this.healthCardRepository = healthCardRepository;
        this.healthCardMapper = healthCardMapper;
        this.animalRepository = animalRepository;
    }

    public HealthCardDto createHealthCard(HealthCardDto healthCardDto) {
        HealthCard healthCard = healthCardMapper.fromDto(healthCardDto);
        HealthCard savedHealthCard = healthCardRepository.save(healthCard);
        return healthCardMapper.toDto(savedHealthCard);
    }

    public HealthCardDto getHealthCard(Long id) {
        HealthCard healthCard = healthCardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("HealthCard with id " + id + " not found"));
        return healthCardMapper.toDto(healthCard);
    }

    public List<HealthCardDto> getAllHealthCards() {
        List<HealthCard> healthCards = healthCardRepository.findAll();
        return healthCards.stream()
                .map(healthCardMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateHealthCard(Long id, HealthCardDto healthCardDto) {
        HealthCard healthCard = healthCardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("HealthCard with id " + id + " not found"));

        healthCard.setDescription(healthCardDto.getDescription());
        healthCard.setWeight(healthCardDto.getWeight());
        healthCard.setHeight(healthCardDto.getHeight());
        healthCard.setLength(healthCardDto.getLength());
        healthCard.setGender(healthCardDto.getGender());
        healthCard.setBornDate(healthCardDto.getBornDate());

        healthCardRepository.save(healthCard);
    }

    public void deleteHealthCard(Long id) {
        healthCardRepository.deleteById(id);
    }

    public List<HealthCardDto> getHealthCardsBySpeciesId(Long speciesId) {

        List<Animal> animals = animalRepository.findAllBySpeciesId(speciesId);

        return animals.stream()
                .map(Animal::getHealthCard)
                .map(healthCardMapper::toDto)
                .collect(Collectors.toList());
    }
}
