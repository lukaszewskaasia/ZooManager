package pl.coderslab.zoomanager.species;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpeciesService {

    private final SpeciesRepository speciesRepository;
    private final SpeciesMapper speciesMapper;

    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository, SpeciesMapper speciesMapper) {
        this.speciesRepository = speciesRepository;
        this.speciesMapper = speciesMapper;
    }

    public SpeciesDto createSpecies(SpeciesDto speciesDto) {
        Species species = speciesMapper.toEntity(speciesDto);
        Species savedSpecies = speciesRepository.save(species);
        return speciesMapper.toDto(savedSpecies);
    }

    public SpeciesDto getSpecies(Long id) {
        Species species = speciesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Species with id " + id + " not found"));
        return speciesMapper.toDto(species);
    }

    public List<SpeciesDto> getAllSpecies() {
        List<Species> speciesList = speciesRepository.findAll();
        return speciesList.stream()
                .map(speciesMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateSpecies(Long id, SpeciesDto speciesDto) {
        Species species = speciesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Species with id " + id + " not found"));

        species.setName(speciesDto.getName());
        species.setFood(speciesDto.getFood());
        species.setStatus(speciesDto.getStatus());

        speciesRepository.save(species);
    }

    public void deleteSpecies(Long id) {
        speciesRepository.deleteById(id);
    }

}

