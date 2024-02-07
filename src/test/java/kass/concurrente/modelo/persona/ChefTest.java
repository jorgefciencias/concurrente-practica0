package kass.concurrente.modelo.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}