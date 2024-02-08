package kass.concurrente.modelo.persona;

import kass.concurrente.modelo.cuchillo.Cuchillo;

/**
 * Clase que modela un chef
 * 
 * @author Kassandra Mirael
 */
public class Chef extends Persona {
  private Cuchillo cuchillo;

  /**
   * Método getter del atributo cuchillo
   * 
   * @return El cuchillo del Chef
   */
  public Cuchillo getCuchillo() {
    return cuchillo;
  }

  /**
   * Método setter del atributo cuchillo
   * 
   * @param cuchillo El nuevo cuchillo del Chef
   */
  public void setCuchillo(Cuchillo cuchillo) {
    this.cuchillo = cuchillo;
  }

  private Chef() {
  }

  private Chef(Builder builder) {
    super(builder);
    this.cuchillo = builder.cuchillo;
  }

  /**
   * Método que regresa una nueva instancia del builder
   * 
   * @return Una nueva instancia del builder para crear un Chef
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Clase que implementa el patrón builder para crear instancias de Chef
   */
  public static class Builder extends Persona.Builder {
    private Cuchillo cuchillo;

    /**
     * Método que asigna un nuevo cuchillo
     * 
     * @param cuchillo El nuevo cuchillo
     * @return La misma instancia del builder
     */
    public Builder setCuchillo(Cuchillo cuchillo) {
      this.cuchillo = cuchillo;
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
    public Chef build() {
      return new Chef(this);
    }
  }
}
