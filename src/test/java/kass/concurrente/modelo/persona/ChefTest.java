package kass.concurrente.modelo.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kass.concurrente.modelo.cuchillo.Cuchillo;
import kass.concurrente.modelo.cuchillo.CuchilloStub;

class ChefTest {
    private Cuchillo cuchillo;

    @BeforeEach
    void setUp() {
        cuchillo = new CuchilloStub();
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el patrón builder")
    void builderPatternTest() {
        final String NOMBRE_CHEF = "Gordon Ramsay";
        final Integer EDAD_CHEF = 57;

        Chef chef = Chef.builder().setCuchillo(cuchillo).setNombre(NOMBRE_CHEF).setEdad(EDAD_CHEF)
                .build();

        assertNotNull(chef);
        assertEquals(NOMBRE_CHEF, chef.getNombre());
        assertEquals(EDAD_CHEF, chef.getEdad());
        assertEquals(cuchillo, chef.getCuchillo());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor vacio")
    void emptyConstructorTest() {
        final String NOMBRE_CHEF = "Gordon Ramsay";
        final Integer EDAD_CHEF = 57;

        Chef chef = new Chef();

        assertNotNull(chef);
        assertNull(chef.getNombre());
        assertNull(chef.getEdad());
        assertNull(chef.getCuchillo());

        chef.setNombre(NOMBRE_CHEF);
        chef.setEdad(EDAD_CHEF);
        chef.setCuchillo(cuchillo);

        assertEquals(NOMBRE_CHEF, chef.getNombre());
        assertEquals(EDAD_CHEF, chef.getEdad());
        assertEquals(cuchillo, chef.getCuchillo());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor y sus parámetros")
    void constructorTest() {
        final String NOMBRE_CHEF = "Benito Molina";
        final Integer EDAD_CHEF = 56;

        Chef chef = new Chef(NOMBRE_CHEF, EDAD_CHEF, cuchillo);

        assertNotNull(chef);
        assertEquals(NOMBRE_CHEF, chef.getNombre());
        assertEquals(EDAD_CHEF, chef.getEdad());
        assertEquals(cuchillo, chef.getCuchillo());
    }
}