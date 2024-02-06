package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductoTest {

    @Test
    @DisplayName("Debe crearse una nueva instancia con el patrón builder")
    void builderPatternTest() {
        final String NOMBRE_PRODUCTO = "Coca Cola 3lt";
        final Double PRECIO_PRODUCTO = 60d;

        Producto producto = Producto.builder()
                .setNombre(NOMBRE_PRODUCTO).setPrecio(PRECIO_PRODUCTO).build();

        assertNotNull(producto);
        assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
        assertEquals(PRECIO_PRODUCTO, producto.getPrecio());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor vacio")
    void emptyConstructorTest() {
        final String NOMBRE_PRODUCTO = "Coca Cola 3lt";
        final Double PRECIO_PRODUCTO = 60d;

        Producto producto = new Producto();

        assertNotNull(producto);
        assertNull(producto.getNombre());
        assertNull(producto.getPrecio());

        producto.setNombre(NOMBRE_PRODUCTO);
        producto.setPrecio(PRECIO_PRODUCTO);

        assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
        assertEquals(PRECIO_PRODUCTO, producto.getPrecio());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor y sus parámetros")
    void constructorTest() {
        final String NOMBRE_PRODUCTO = "Gansito";
        final Double PRECIO_PRODUCTO = 24d;

        Producto producto = new Producto(NOMBRE_PRODUCTO, PRECIO_PRODUCTO);

        assertNotNull(producto);
        assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
        assertEquals(PRECIO_PRODUCTO, producto.getPrecio());
    }
}
