package pl.coderslab.zoomanager.species;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SpeciesDto {
    @Schema(description = "Species id", example = "1")
    private Long id;
    @NotBlank(message = "Name cannot be null")
    @Schema(description = "Species name", example = "Polar Bear", required = true)
    private String name;
    @NotNull(message = "Food cannot be null")
    @Schema(description = "Species food", example = "Seals", required = true)
    private String food;
    @NotNull(message = "Status cannot be null")
    @Schema(description = "Species status", example = "Endangered", required = true)
    private String status;

    public SpeciesDto() {
    }

    public SpeciesDto(Long id, String name, String food, String status) {
        this.id = id;
        this.name = name;
        this.food = food;
        this.status = status;
    }

    public SpeciesDto(Species species) {
        this.id = species.getId();
        this.name = species.getName();
        this.food = species.getFood();
        this.status = species.getStatus();
    }

    @Override
    public String toString() {
        return "SpeciesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}