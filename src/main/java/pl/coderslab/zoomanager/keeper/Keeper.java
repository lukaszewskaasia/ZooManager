package pl.coderslab.zoomanager.keeper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.zoomanager.animal.Animal;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
public class Keeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "keepers")
    private Set<Animal> animals = new HashSet<>();

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @Length(min = 5, max = 50)
    private String surname;

    @NotNull(message = "Address cannot be null")
    private String address;

    @NotNull(message = "Phone cannot be null")
    private Integer phone;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    //zostawic na przyszlosc
    private String password;

    @NotNull(message = "Username cannot be null")
    @Column(unique = true, nullable = false)
    //to tez na przyszlosc
    private String username;

    public Keeper(String name, String surname, String address, String email, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}