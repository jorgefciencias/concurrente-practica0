package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto de un inventario
 * 
 * @author Kassandra Mirael
 */
public class ProductoInventario extends Producto {
    private Integer cantidad;

    /**
     * Método getter del atributo cantidad
     * 
     * @return La cantidad del inventario
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Método setter del atributo cantidad
     * 
     * @param cantidad La cantidad del inventario
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoInventario() {
    }

    public ProductoInventario(String nombre, Double precio, Integer cantidad) {
        super(nombre, precio);
        this.cantidad = cantidad;
    }

    private ProductoInventario(Builder builder) {
        super(builder);
        this.cantidad = builder.cantidad;
    }

    /**
     * Método que regresa una nueva instancia del builder
     * 
     * @return Una nueva instancia del builder para crear un ProductoInventario
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Clase que implementa el patrón builder para crear instancias de
     * ProductoInventario
     */
    public static class Builder extends Producto.Builder {
        private Integer cantidad;

        /**
         * Método que asigna una nueva cantidad
         * 
         * @param cantidad La nueva cantidad
         * @return La misma instancia del builder
         */
        public Builder setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
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
        public Builder setPrecio(Double precio) {
            return (Builder) super.setPrecio(precio);
        }

        private Builder() {
        }

        public ProductoInventario build() {
            return new ProductoInventario(this);
        }
    }
}
