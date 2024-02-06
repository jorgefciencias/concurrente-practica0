package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto de un inventario
 * 
 * @author Kassandra Mirael
 */
public class ProductoInventario extends Producto {
    private Integer cantidad;

    public Integer getCantidad() {
        return cantidad;
    }

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Producto.Builder {
        private Integer cantidad;

        public Builder setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        @Override
        public Builder setNombre(String nombre) {
            return (Builder) super.setNombre(nombre);
        }

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
