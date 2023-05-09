package pl.coderslab.zoomanager.HealthCard;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class HealthCardDto {

    @Schema(description = "HealtCard id", example = "1")
    private Long id;
    @Schema(description = "HealthCard description", example = "example description", required = true)
    @NotBlank
    private String description;
    @Schema(description = "Animal weight", example = "20", required = true)
    @Range(min = 0, max = 200)
    private Long weight;
    @Schema(description = "Animal height", example = "120", required = true)
    @Range(min = 0, max = 2000)
    private Long height;
    @Schema(description = "Animal length", example = "55", required = true)
    @Range(min = 0, max = 3000)
    private Long length;
    @Schema(description = "Animal gender", example = "K", required = true)
   //jak zrobic zeby bylo k albo m?
    private Boolean gender;
    @Schema(description = "Animal bornDate", example = "05.05.1993", required = true)
    private LocalDate bornDate;
}