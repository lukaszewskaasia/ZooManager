package pl.coderslab.zoomanager.species;

import org.springframework.stereotype.Component;

@Component
public class SpeciesMapper {

    public SpeciesDto toDto(Species species) {
        SpeciesDto speciesDto = new SpeciesDto();
        speciesDto.setId(species.getId());
        speciesDto.setName(species.getName());
        speciesDto.setFood(species.getFood());
        speciesDto.setStatus(species.getStatus());
        return speciesDto;
    }

    public Species toEntity(SpeciesDto speciesDto) {
        Species species = new Species();
        species.setId(speciesDto.getId());
        species.setName(speciesDto.getName());
        species.setFood(speciesDto.getFood());
        species.setStatus(speciesDto.getStatus());
        return species;
    }

}
