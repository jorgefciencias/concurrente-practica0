package kass.concurrente.modelo.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
