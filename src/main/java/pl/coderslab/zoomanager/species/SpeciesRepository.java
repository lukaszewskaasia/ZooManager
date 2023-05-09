package pl.coderslab.zoomanager.species;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Optional<Species> findByName(String name);
    List<Species> findByFood(String food);
    List<Species> findByStatus(String status);

}
