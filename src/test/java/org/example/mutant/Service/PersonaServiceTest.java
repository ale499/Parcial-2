package org.example.mutant.Service;

import org.example.mutant.Entities.Persona;
import org.example.mutant.Repositories.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarPersona() {
        // Crear una persona de prueba
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"));

        // Configurar el mock para devolver la persona cuando se guarde
        when(personaRepository.save(any(Persona.class))).thenReturn(persona);

        // Llamar al método de guardar
        Persona result = personaService.save(persona);

        // Verificar que el método save del repositorio fue llamado
        verify(personaRepository).save(persona);

        // Verificar que la persona guardada es la misma que la de prueba
        assertEquals(persona, result);
    }

    @Test
    public void testEsMutanteTrue() {
        // Caso mutante
        String[] dnaMutante = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(personaService.Esmutante(dnaMutante));
    }

    @Test
    public void testEsMutanteFalse() {
        // Caso no mutante
        String[] dnaNoMutante = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };
        assertFalse(personaService.Esmutante(dnaNoMutante));
    }






}