package kass.concurrente.modelo.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kass.concurrente.modelo.producto.Platillo;

import java.util.List;
import java.util.LinkedList;

class ClienteTest {
  private List<Platillo> orden;

  @BeforeEach
  void setUp() {
    orden = new LinkedList<>();

    orden.add(Platillo.builder().build());
    orden.add(Platillo.builder().build());
    orden.add(Platillo.builder().build());
  }

  @Test
  @DisplayName("Debe crearse una nueva instancia con el patrón builder")
  void builderPatternTest() {
    final String NOMBRE_CLIENTE = "Gordon Ramsay";
    final Integer EDAD_CLIENTE = 57;

    Cliente cliente = Cliente.builder().setNombre(NOMBRE_CLIENTE).setEdad(EDAD_CLIENTE).build();

    assertNotNull(cliente);
    assertEquals(NOMBRE_CLIENTE, cliente.getNombre());
    assertEquals(EDAD_CLIENTE, cliente.getEdad());
    assertEquals(orden, cliente.getOrden());
  }
}