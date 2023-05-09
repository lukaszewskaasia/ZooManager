package pl.coderslab.zoomanager.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import pl.coderslab.zoomanager.HealthCard.HealthCard;
import pl.coderslab.zoomanager.keeper.Keeper;
import pl.coderslab.zoomanager.species.Species;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotBlank
    private Species species;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @NotBlank
    private HealthCard healthCard;

    @ManyToMany
    @JoinTable(
            name = "animals_keepers",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "keeper_id"))
    private Set<Keeper> keepers = new HashSet<>();

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Adopt date cannot be null")
    private Date adoptDate;

    @NotBlank
    private String description;

    public Animal(String name, Date adoptDate, Species species, HealthCard healthCard) {
        this.name = name;
        this.adoptDate = adoptDate;
        this.species = species;
        this.healthCard = healthCard;
    }

    public void addKeeper(Keeper keeper) {
        this.keepers.add(keeper);
    }

    public void removeKeeper(Keeper keeper) {
        System.out.println("Removing keeper " + this.keepers);
        this.keepers.remove(keeper);
        System.out.println("Keeper removed" + this.keepers);
    }
}