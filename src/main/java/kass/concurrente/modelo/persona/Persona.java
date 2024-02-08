package kass.concurrente.modelo.persona;

/**
 * Clase que modela una persona
 * 
 * @author Kassandra Mirael
 */
public class Persona {
  protected String nombre;
  protected Integer edad;

  /**
   * Método getter del atributo nombre
   * 
   * @return El nombre de la persona
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Método setter del atributo nombre
   * 
   * @param nombre El nuevo nombre de la persona
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Método getter del atributo edad
   * 
   * @return La edad de la persona
   */
  public Integer getEdad() {
    return edad;
  }

  /**
   * Método setter del atributo edad
   * 
   * @param edad La nueva edad de la persona
   */
  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  protected Persona() {
  }

  protected Persona(Builder builder) {
    this.nombre = builder.nombre;
    this.edad = builder.edad;
  }

  /**
   * Método que regresa una nueva instancia del builder
   * 
   * @return Una nueva instancia del builder para crear una persona
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Clase que implementa el patrón builder para crear instancias de Persona
   */
  public static class Builder {
    private String nombre;
    private Integer edad;

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
     * Método que asigna una nueva edad
     * 
     * @param edad La nueva edad
     * @return La misma instancia del builder
     */
    public Builder setEdad(Integer edad) {
      this.edad = edad;
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
    public Persona build() {
      return new Persona(this);
    }
  }
}