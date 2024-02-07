package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
