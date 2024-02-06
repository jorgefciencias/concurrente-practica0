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

    public Integer getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(Integer tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Platillo() {
    }

    public Platillo(String nombre, Integer tiempoCoccion, List<Producto> productos) {
        this.nombre = nombre;
        this.tiempoCoccion = tiempoCoccion;
        this.productos = productos;
    }

    public Platillo(String nombre, Integer tiempoCoccion, List<Producto> productos, Double precio) {
        this(nombre, tiempoCoccion, productos);
        this.precio = precio;
    }

    private Platillo(Builder builder) {
        this.nombre = builder.nombre;
        this.tiempoCoccion = builder.tiempoCoccion;
        this.productos = builder.productos;
        this.precio = builder.precio;
    }

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

    public static class Builder {
        private String nombre;
        private Integer tiempoCoccion;
        private List<Producto> productos;
        private Double precio;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setTiempoCoccion(Integer tiempoCoccion) {
            this.tiempoCoccion = tiempoCoccion;
            return this;
        }

        public Builder setProductos(List<Producto> productos) {
            this.productos = productos;
            return this;
        }

        public Builder setPrecio(Double precio) {
            this.precio = precio;
            return this;
        }

        public Platillo build() {
            return new Platillo(this);
        }
    }
}
