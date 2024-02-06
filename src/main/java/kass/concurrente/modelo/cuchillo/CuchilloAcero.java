package kass.concurrente.modelo.cuchillo;

/**
 * Clase que modela un cuchillo de acero
 * 
 * @author Jorge Ramón
 * @version 1.0
 */
public class CuchilloAcero implements Cuchillo {

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer corta() {
    return 3;
  }
}
