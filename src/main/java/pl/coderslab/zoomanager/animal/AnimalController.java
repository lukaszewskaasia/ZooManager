package pl.coderslab.zoomanager.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.zoomanager.keeper.Keeper;
import pl.coderslab.zoomanager.keeper.KeeperRepository;
import pl.coderslab.zoomanager.keeper.exception.KeeperNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final KeeperRepository keeperRepository;
    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalController(AnimalService animalService, KeeperRepository keeperRepository, AnimalMapper animalMapper) {
        this.animalService = animalService;
        this.keeperRepository = keeperRepository;
        this.animalMapper = animalMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> getAnimal(@PathVariable Long id) {
        AnimalDto animalDto = animalService.getAnimal(id);
        return ResponseEntity.ok(animalDto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalDto>> getAllAnimals() {
        List<AnimalDto> animalDtos = animalService.getAllAnimals();
        return ResponseEntity.ok(animalDtos);
    }

    @PostMapping
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody @Valid AnimalDto animal) {
        AnimalDto animalDto = animalService.createAnimal(animal);
        return ResponseEntity.ok(animalDto);

        // @PostMapping
        //    public ResponseEntity<MovieDto> addMovie(@RequestBody @Valid MovieDto movie) {
        //        MovieDto movieDto = movieService.addMovie(movie);
        //        return ResponseEntity.ok(movieDto);
        //    }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAnimal(@PathVariable Long id, @RequestBody @Valid AnimalDto animalDto) {
        animalService.updateAnimal(id, animalDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/keeper/{keeperId}")
    public ResponseEntity<List<AnimalDto>> getAnimalsByKeeperId(@PathVariable Long keeperId) {

        Keeper keeper = keeperRepository.findById(keeperId)
                .orElseThrow(KeeperNotFoundException::new);

        List<AnimalDto> animals = keeper.getAnimals().stream()
                .map(animalMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(animals);
    }
}
