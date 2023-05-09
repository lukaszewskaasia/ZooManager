package pl.coderslab.zoomanager.HealthCard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class HealthCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Weight cannot be null")
    private Long weight;

    @NotNull(message = "Height cannot be null")
    private Long height;

    @NotNull(message = "Length cannot be null")
    private Long length;

    @NotNull(message = "Gender cannot be null")
    private Boolean gender;
    private LocalDate bornDate;

    public HealthCard(String description, Long weight, Long height, Long length, Boolean gender, LocalDate bornDate) {
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.gender = gender;
        this.bornDate = bornDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}