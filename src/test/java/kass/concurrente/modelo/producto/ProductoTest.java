package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
