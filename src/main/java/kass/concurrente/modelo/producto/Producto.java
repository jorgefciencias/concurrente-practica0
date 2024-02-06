package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto
 * 
 * @author Kassandra Mirael
 */
public class Producto {
  protected String nombre;
  protected Double precio;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public Producto() {
  }

  public Producto(String nombre, Double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  protected Producto(Builder builder) {
    this.nombre = builder.nombre;
    this.precio = builder.precio;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    protected String nombre;
    protected Double precio;

    public Builder setNombre(String nombre) {
      this.nombre = nombre;
      return this;
    }

    public Builder setPrecio(Double precio) {
      this.precio = precio;
      return this;
    }

    protected Builder() {
    }

    public Producto build() {
      return new Producto(this);
    }
  }
}
