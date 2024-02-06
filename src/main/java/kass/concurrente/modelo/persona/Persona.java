package kass.concurrente.modelo.persona;

/**
 * Clase que modela una persona
 * 
 * @author Kassandra Mirael
 */
public class Persona {
  protected String nombre;
  protected Integer edad;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public Persona() {
  }

  public Persona(String nombre, Integer edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  protected Persona(Builder builder) {
    this.nombre = builder.nombre;
    this.edad = builder.edad;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String nombre;
    private Integer edad;

    public Builder setNombre(String nombre) {
      this.nombre = nombre;
      return this;
    }

    public Builder setEdad(Integer edad) {
      this.edad = edad;
      return this;
    }

    protected Builder() {
    }

    public Persona build() {
      return new Persona(this);
    }
  }
}