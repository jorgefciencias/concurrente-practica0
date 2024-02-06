package kass.concurrente.modelo.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonaTest {

  @Test
  @DisplayName("Debe crearse una nueva instancia con el patrón builder")
  void builderPatternTest() {
    final String NOMBRE_PERSONA = "Juan Perez";
    final Integer EDAD_PERSONA = 30;

    Persona persona = Persona.builder().setNombre(NOMBRE_PERSONA).setEdad(EDAD_PERSONA)
        .build();

    assertNotNull(persona);
    assertEquals(NOMBRE_PERSONA, persona.getNombre());
    assertEquals(EDAD_PERSONA, persona.getEdad());
  }

  @Test
  @DisplayName("Debe crearse una nueva instancia con el constructor vacio")
  void emptyConstructorTest() {
    final String NOMBRE_PERSONA = "Juan Perez";
    final Integer EDAD_PERSONA = 30;

    Persona persona = new Persona();

    assertNotNull(persona);
    assertNull(persona.getNombre());
    assertNull(persona.getEdad());

    persona.setNombre(NOMBRE_PERSONA);
    persona.setEdad(EDAD_PERSONA);

    assertEquals(NOMBRE_PERSONA, persona.getNombre());
    assertEquals(EDAD_PERSONA, persona.getEdad());
  }

  @Test
  @DisplayName("Debe crearse una nueva instancia con el constructor y sus parámetros")
  void constructorTest() {
    final String NOMBRE_PERSONA = "John Doe";
    final Integer EDAD_PERSONA = 32;

    Persona persona = new Persona(NOMBRE_PERSONA, EDAD_PERSONA);

    assertNotNull(persona);
    assertEquals(NOMBRE_PERSONA, persona.getNombre());
    assertEquals(EDAD_PERSONA, persona.getEdad());
  }
}
