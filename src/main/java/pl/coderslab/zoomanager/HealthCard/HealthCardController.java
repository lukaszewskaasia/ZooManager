package pl.coderslab.zoomanager.HealthCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.zoomanager.animal.AnimalRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/health-cards")
public class HealthCardController {

    private final HealthCardService healthCardService;
    private final AnimalRepository animalRepository;
    private final HealthCardMapper healthCardMapper;

    @Autowired
    public HealthCardController(HealthCardService healthCardService, AnimalRepository animalRepository,
                                HealthCardMapper healthCardMapper) {
        this.healthCardService = healthCardService;
        this.animalRepository = animalRepository;
        this.healthCardMapper = healthCardMapper;
    }

    @PostMapping
    public ResponseEntity<HealthCardDto> createHealthCard(@RequestBody @Valid HealthCardDto healthCardDto) {
        HealthCardDto createdHealthCard = healthCardService.createHealthCard(healthCardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthCardDto> getHealthCard(@PathVariable Long id) {
        HealthCardDto healthCardDto = healthCardService.getHealthCard(id);
        return ResponseEntity.ok(healthCardDto);
    }

    @GetMapping
    public ResponseEntity<List<HealthCardDto>> getAllHealthCards() {
        List<HealthCardDto> healthCards = healthCardService.getAllHealthCards();
        return ResponseEntity.ok(healthCards);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateHealthCard(@PathVariable Long id, @RequestBody @Valid HealthCardDto healthCardDto) {
        healthCardService.updateHealthCard(id, healthCardDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthCard(@PathVariable Long id) {
        healthCardService.deleteHealthCard(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/species/{speciesId}")
    public ResponseEntity<List<HealthCardDto>> getHealthCardsBySpeciesId(@PathVariable Long speciesId) {
        List<HealthCardDto> healthCards = healthCardService.getHealthCardsBySpeciesId(speciesId);
        return ResponseEntity.ok(healthCards);
    }
}
