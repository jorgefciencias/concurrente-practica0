package kass.concurrente.modelo.producto;

import java.util.List;

/**
 * Clase que modela un platillo
 * 
 * @author Kassandra Mirael
 */
public class Platillo {

    private String nombre;
    private Integer tiempoCoccion;
    private List<Producto> productos;
    private Double precio;

    /**
     * Método getter del atributo nombre
     * 
     * @return El nombre del platillo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter del atributo nombre
     * 
     * @param nombre El nuevo nombre del platillo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter del atributo precio
     * 
     * @return El precio del platillo
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Método setter del atributo precio
     * 
     * @param precio El nuevo precio del platillo
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Método getter del atributo tiempoCoccion
     * 
     * @return El tiempo de cocción del platillo
     */
    public Integer getTiempoCoccion() {
        return tiempoCoccion;
    }

    /**
     * Método setter del atributo tiempoCoccion
     * 
     * @param tiempoCoccion El nuevo tiempo de cocción del platillo
     */
    public void setTiempoCoccion(Integer tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    /**
     * Método getter del atributo productos
     * 
     * @return La lista de productos que conforman el platillo
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Método setter del atributo productos
     * 
     * @param productos La nueva lista de productos del platillo
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    private Platillo() {
    }

    private Platillo(Builder builder) {
        this.nombre = builder.nombre;
        this.tiempoCoccion = builder.tiempoCoccion;
        this.productos = builder.productos;
        this.precio = builder.precio;
    }

    /**
     * Método que regresa una nueva instancia del builder
     * 
     * @return Una nueva instancia del builder para crear un Platillo
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Este metodo calcula el precio sobre el precio de los items, se ignora
     * el precio base.
     * 
     * @return El precio de la suma de cada item utilizado
     */
    public Double calculaPrecio() {
        return productos.stream().reduce(0.0, (total, producto) -> total + producto.getPrecio(), Double::sum);
    }

    /**
     * Clase que implementa el patrón builder para crear instancias de Platillo
     */
    public static class Builder {
        private String nombre;
        private Integer tiempoCoccion;
        private List<Producto> productos;
        private Double precio;

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
         * Método que asigna un nuevo tiempo de cocción
         * 
         * @param tiempoCoccion El nuevo tiempo de cocción
         * @return La misma instancia del builder
         */
        public Builder setTiempoCoccion(Integer tiempoCoccion) {
            this.tiempoCoccion = tiempoCoccion;
            return this;
        }

        /**
         * Método que asigna una nueva lista de productos
         * 
         * @param productos La nueva lista de productos
         * @return La misma instancia del builder
         */
        public Builder setProductos(List<Producto> productos) {
            this.productos = productos;
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

        /**
         * Método que crea una nueva instancia de la clase a partir
         * de los datos construidos
         * 
         * @return La nueva instancia de la clase
         */
        public Platillo build() {
            return new Platillo(this);
        }
    }
}
