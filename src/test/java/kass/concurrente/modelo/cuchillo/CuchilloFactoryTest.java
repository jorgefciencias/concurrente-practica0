package kass.concurrente.modelo.cuchillo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CuchilloFactoryTest {

  @Test
  @DisplayName("Debe crear y entregar una instancia de un cuchillo de plástico")
  void plasticTest() {
    Cuchillo cuchillo = CuchilloFactory.obtenerCuchillo(TipoCuchillo.PLASTICO);

    assertNotNull(cuchillo);
    assertTrue(cuchillo instanceof CuchilloPlastico);
    assertEquals(1, cuchillo.corta());
  }

  @Test
  @DisplayName("Debe crear y entregar una instancia de un cuchillo de acero")
  void ironTest() {
    Cuchillo cuchillo = CuchilloFactory.obtenerCuchillo(TipoCuchillo.ACERO);

    assertNotNull(cuchillo);
    assertTrue(cuchillo instanceof CuchilloAcero);
    assertEquals(3, cuchillo.corta());
  }

  @Test
  @DisplayName("Debe crear y entregar una instancia de un cuchillo de plástico")
  void jadeTest() {
    Cuchillo cuchillo = CuchilloFactory.obtenerCuchillo(TipoCuchillo.JADE);

    assertNotNull(cuchillo);
    assertTrue(cuchillo instanceof CuchilloJade);
    assertEquals(5, cuchillo.corta());
  }
}
