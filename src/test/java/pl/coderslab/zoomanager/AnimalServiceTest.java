package pl.coderslab.zoomanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.zoomanager.animal.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;
    @Mock
    private AnimalMapper animalMapper;
    @InjectMocks
    private AnimalService animalService;

    @Test
    public void shouldReturnEmptyList_whenThereAreNoAnimalsInTheZoo() {
        //Given
        when(animalRepository.findAll()).thenReturn(Collections.emptyList());

        //When
        List<AnimalDto> animals = animalService.getAllAnimals();

        //Then
        assertThat(animals).isEmpty();
    }

    @Test
    public void testGetAllAnimals() {
        // Given
        Animal animal1 = new Animal();
        animal1.setId(1L);
        animal1.setName("Dog");
        Animal animal2 = new Animal();
        animal2.setId(2L);
        animal2.setName("Cat");
        List<Animal> animals = Arrays.asList(animal1, animal2);
        when(animalRepository.findAll()).thenReturn(animals);

        AnimalDto animalDto1 = new AnimalDto();
        animalDto1.setName("Dog");
        AnimalDto animalDto2 = new AnimalDto();
        animalDto2.setName("Cat");
        List<AnimalDto> animalDtos = Arrays.asList(animalDto1, animalDto2);
        when(animalMapper.toDto(animal1)).thenReturn(animalDto1);
        when(animalMapper.toDto(animal2)).thenReturn(animalDto2);

        // When
        List<AnimalDto> retrievedAnimalDtos = new AnimalService(animalRepository, animalMapper)
                .getAllAnimals();

        // Then
        assertNotNull(retrievedAnimalDtos);
        assertEquals(animalDtos.size(), retrievedAnimalDtos.size());
        assertEquals(animalDtos.get(0), retrievedAnimalDtos.get(0));
        assertEquals(animalDtos.get(1), retrievedAnimalDtos.get(1));
        verify(animalRepository, times(1)).findAll();
        verify(animalMapper, times(1)).toDto(animal1);
        verify(animalMapper, times(1)).toDto(animal2);
    }


}
