package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductoInventarioTest {

    @Test
    @DisplayName("Debe crearse una nueva instancia con el patrón builder")
    void builderPatternTest() {
        final String NOMBRE_PRODUCTO = "Crema Alpura 1lt";
        final Double PRECIO_PRODUCTO = 52d;
        final Integer CANTIDAD_PRODUCTO = 5;

        ProductoInventario producto = ProductoInventario.builder()
                .setCantidad(CANTIDAD_PRODUCTO).setNombre(NOMBRE_PRODUCTO).setPrecio(PRECIO_PRODUCTO).build();

        assertNotNull(producto);
        assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
        assertEquals(PRECIO_PRODUCTO, producto.getPrecio());
        assertEquals(CANTIDAD_PRODUCTO, producto.getCantidad());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor vacio")
    void emptyConstructorTest() {
        final String NOMBRE_PRODUCTO = "Crema Alpura 1lt";
        final Double PRECIO_PRODUCTO = 52d;
        final Integer CANTIDAD_PRODUCTO = 5;

        ProductoInventario producto = new ProductoInventario();

        assertNotNull(producto);
        assertNull(producto.getNombre());
        assertNull(producto.getPrecio());
        assertNull(producto.getCantidad());

        producto.setNombre(NOMBRE_PRODUCTO);
        producto.setPrecio(PRECIO_PRODUCTO);
        producto.setCantidad(CANTIDAD_PRODUCTO);

        assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
        assertEquals(PRECIO_PRODUCTO, producto.getPrecio());
        assertEquals(CANTIDAD_PRODUCTO, producto.getCantidad());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor y sus parámetros")
    void constructorTest() {
        final String NOMBRE_PRODUCTO = "Pan Bimbo Grande";
        final Double PRECIO_PRODUCTO = 54d;
        final Integer CANTIDAD_PRODUCTO = 8;

        ProductoInventario producto = new ProductoInventario(NOMBRE_PRODUCTO, PRECIO_PRODUCTO, CANTIDAD_PRODUCTO);

        assertNotNull(producto);
        assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
        assertEquals(PRECIO_PRODUCTO, producto.getPrecio());
        assertEquals(CANTIDAD_PRODUCTO, producto.getCantidad());
    }
}
