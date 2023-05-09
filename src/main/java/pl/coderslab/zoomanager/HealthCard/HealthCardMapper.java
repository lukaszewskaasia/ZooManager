package pl.coderslab.zoomanager.HealthCard;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HealthCardMapper {
    HealthCardDto toDto(HealthCard healthCard);

    HealthCard fromDto(HealthCardDto healthCardDto);
}
