package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto
 * 
 * @author Kassandra Mirael
 */
public class Producto {
  protected String nombre;
  protected Double precio;

  /**
   * Método getter del atributo nombre
   * 
   * @return El nombre del producto
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Método setter del atributo nombre
   * 
   * @param nombre El nuevo nombre del producto
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Método getter del atributo precio
   * 
   * @return El precio del producto
   */
  public Double getPrecio() {
    return precio;
  }

  /**
   * Método setter del atributo precio
   * 
   * @param precio El nuevo precio del producto
   */
  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  protected Producto() {
  }

  protected Producto(Builder builder) {
    this.nombre = builder.nombre;
    this.precio = builder.precio;
  }

  /**
   * Método que regresa una nueva instancia del builder
   * 
   * @return Una nueva instancia del builder para crear un Producto
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Clase que implementa el patrón builder para crear instancias de Producto
   */
  public static class Builder {
    protected String nombre;
    protected Double precio;

    /**
     * Método que asigna un nuevo nombre
     * 
     * @param nombre El nuevo nombre
     * @return La misma instancia del builder
     */
    public Builder setNombre(String nombre) {
      this.nombre = nombre;
      return this;
    }

    /**
     * Método que asigna un nuevo precio
     * 
     * @param precio El nuevo precio
     * @return La misma instancia del builder
     */
    public Builder setPrecio(Double precio) {
      this.precio = precio;
      return this;
    }

    protected Builder() {
    }

    /**
     * Método que crea una nueva instancia de la clase a partir
     * de los datos construidos
     * 
     * @return La nueva instancia de la clase
     */
    public Producto build() {
      return new Producto(this);
    }
  }
}
