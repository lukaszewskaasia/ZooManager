package pl.coderslab.zoomanager.species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @PostMapping
    public ResponseEntity<SpeciesDto> createSpecies(@RequestBody @Valid SpeciesDto speciesDto) {
        SpeciesDto createdSpecies = speciesService.createSpecies(speciesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpecies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeciesDto> getSpecies(@PathVariable Long id) {
        SpeciesDto species = speciesService.getSpecies(id);
        return ResponseEntity.ok(species);
    }

    @GetMapping
    public ResponseEntity<List<SpeciesDto>> getAllSpecies() {
        List<SpeciesDto> speciesList = speciesService.getAllSpecies();
        return ResponseEntity.ok(speciesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSpecies(@PathVariable Long id, @RequestBody @Valid SpeciesDto speciesDto) {
        speciesService.updateSpecies(id, speciesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable Long id) {
        speciesService.deleteSpecies(id);
        return ResponseEntity.ok().build();
    }
}
