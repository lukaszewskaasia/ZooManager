package pl.coderslab.zoomanager.animal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.zoomanager.HealthCard.HealthCard;
import pl.coderslab.zoomanager.keeper.Keeper;
import pl.coderslab.zoomanager.species.Species;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AnimalDto {
    private Species species;
    private HealthCard healthCard;
    private Set<Keeper> keepers = new HashSet<>();
    @Schema(description = "Animal name", example = "Elephant", required = true)
    @NotBlank
    private String name;
    private Date adoptDate;
    private String description;
}
