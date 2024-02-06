package kass.concurrente.modelo.persona;

import kass.concurrente.modelo.cuchillo.Cuchillo;

/**
 * Clase que modela un chef
 * 
 * @author Kassandra Mirael
 */
public class Chef extends Persona {
  private Cuchillo cuchillo;

  public Cuchillo getCuchillo() {
    return cuchillo;
  }

  public void setCuchillo(Cuchillo cuchillo) {
    this.cuchillo = cuchillo;
  }

  public Chef() {
    super();
  }

  public Chef(String nombre, Integer edad, Cuchillo cuchillo) {
    this.nombre = nombre;
    this.edad = edad;
    this.cuchillo = cuchillo;
  }

  private Chef(Builder builder) {
    super(builder);
    this.cuchillo = builder.cuchillo;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends Persona.Builder {
    private Cuchillo cuchillo;

    public Builder setCuchillo(Cuchillo cuchillo) {
      this.cuchillo = cuchillo;
      return this;
    }

    @Override
    public Builder setNombre(String nombre) {
      return (Builder) super.setNombre(nombre);
    }

    @Override
    public Builder setEdad(Integer edad) {
      return (Builder) super.setEdad(edad);
    }

    private Builder() {
    }

    public Chef build() {
      return new Chef(this);
    }
  }
}
