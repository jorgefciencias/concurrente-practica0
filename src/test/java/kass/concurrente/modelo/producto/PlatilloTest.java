package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlatilloTest {

    private List<Producto> productos;

    @BeforeEach
    void setup() {
        productos = new ArrayList<>();

        productos.add(Producto.builder().setNombre("Tortilla").setPrecio(1d).build());
        productos.add(Producto.builder().setNombre("Aguacate").setPrecio(5d).build());
        productos.add(Producto.builder().setNombre("Frijoles Refritos").setPrecio(3d).build());
        productos.add(Producto.builder().setNombre("Queso").setPrecio(10d).build());
        productos.add(Producto.builder().setNombre("Carne de Res").setPrecio(30d).build());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el patrón builder")
    void builderPatternTest() {
        final String NOMBRE_PLATILLO = "Burrito";
        final Double PRECIO_PLATILLO = 60d;
        final Integer TIEMPO_PLATILLO = 10;

        Platillo platillo = Platillo.builder().setNombre(NOMBRE_PLATILLO).setPrecio(PRECIO_PLATILLO)
                .setProductos(productos)
                .setTiempoCoccion(TIEMPO_PLATILLO).build();

        assertNotNull(platillo);
        assertEquals(NOMBRE_PLATILLO, platillo.getNombre());
        assertEquals(PRECIO_PLATILLO, platillo.getPrecio());
        assertEquals(TIEMPO_PLATILLO, platillo.getTiempoCoccion());
        assertEquals(productos, platillo.getProductos());
    }

    @Test
    @DisplayName("Debe calcular el precio del platillo")
    void calculateTest() {
        final String NOMBRE_PLATILLO = "Burrito";
        final Integer TIEMPO_PLATILLO = 10;

        Platillo platillo = Platillo.builder().setNombre(NOMBRE_PLATILLO)
                .setProductos(productos)
                .setTiempoCoccion(TIEMPO_PLATILLO).build();

        Double precio = platillo.calculaPrecio();

        assertEquals(49d, precio);
    }
}
