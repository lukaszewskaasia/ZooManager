package pl.coderslab.zoomanager.species;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Column(name="name", unique = true, nullable = false)
    private String name;

    @NotNull(message = "Food cannot be null")
    private String food;

    @NotNull(message = "Status cannot be null")
    private String status;


    public Species() {
    }

    public Species(String name, String description, String type, String food, String habitat, String status, String image) {
        this.name = name;
        this.food = food;
        this.status = status;
    }

    public Species(Species specie) {
        this.name = specie.getName();
        this.food = specie.getFood();
        this.status = specie.getStatus();
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}