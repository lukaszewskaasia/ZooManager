package pl.coderslab.zoomanager.animal;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AnimalMapper {

     AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

     AnimalDto toDto(Animal animal);

     @InheritInverseConfiguration
     Animal fromDto(AnimalDto animalDto);
}