package kass.concurrente.modelo.cuchillo;

/**
 * Clase que modela un cuchillo de plástico
 * 
 * @author Jorge Ramón
 * @version 1.0
 */
public class CuchilloPlastico implements Cuchillo {

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer corta() {
    return 1;
  }
}
