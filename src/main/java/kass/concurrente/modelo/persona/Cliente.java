package kass.concurrente.modelo.persona;

import kass.concurrente.modelo.producto.Platillo;

import java.util.List;

/**
 * Clase que modela un cliente
 * 
 * @author Jorge Ramón
 * @version 1.0
 */
public class Cliente extends Persona {
  private List<Platillo> orden;

  /**
   * Método getter del atributo orden
   * 
   * @return La orden del cliente
   */
  public List<Platillo> getOrden() {
    return orden;
  }

  /**
   * Método setter del atributo orden
   * 
   * @param orden La nueva orden del cliente
   */
  public void setOrden(List<Platillo> orden) {
    this.orden = orden;
  }

  private Cliente() {
  }

  private Cliente(Builder builder) {
    super(builder);
    this.orden = builder.orden;
  }

  /**
   * Método que regresa una nueva instancia del builder
   * 
   * @return Una nueva instancia del builder para crear un Cliente
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Clase que implementa el patrón builder para crear instancias de Cliente
   */
  public static class Builder extends Persona.Builder {
    private List<Platillo> orden;

    /**
     * Método que asigna una nueva orden
     * 
     * @param orden La nueva orden
     * @return La misma instancia del builder
     */
    public Builder setOrden(List<Platillo> orden) {
      this.orden = orden;
      return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Builder setNombre(String nombre) {
      return (Builder) super.setNombre(nombre);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Builder setEdad(Integer edad) {
      return (Builder) super.setEdad(edad);
    }

    private Builder() {
    }

    /**
     * Método que crea una nueva instancia de la clase a partir
     * de los datos construidos
     * 
     * @return La nueva instancia de la clase
     */
    @Override
    public Cliente build() {
      return new Cliente(this);
    }
  }
}
