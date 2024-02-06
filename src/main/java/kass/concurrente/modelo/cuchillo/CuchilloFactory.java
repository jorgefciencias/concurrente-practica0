package kass.concurrente.modelo.cuchillo;

/**
 * Clase que implementa el patrón "Factory" para
 * crear instancias de cuchillos.
 * 
 * @author Jorge Ramón
 * @version 1.0
 */
public class CuchilloFactory {

  /**
   * Método estático que entrega una instancia de un cuchillo
   * dependiendo su tipo.
   * 
   * @param tipo Tipo de cuchillo a ser creado
   * @return La instancia del cuchillo dependiendo su tipo
   */
  public static Cuchillo obtenerCuchillo(TipoCuchillo tipo) {
    switch (tipo) {
      case PLASTICO:
        return new CuchilloPlastico();

      case ACERO:
        return new CuchilloAcero();

      default:
        return new CuchilloJade();
    }
  }
}
