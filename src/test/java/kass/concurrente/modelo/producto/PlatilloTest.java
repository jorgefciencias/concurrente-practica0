package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    @DisplayName("Debe crearse una nueva instancia con el constructor vacio")
    void emptyConstructorTest() {
        final String NOMBRE_PLATILLO = "Burrito";
        final Double PRECIO_PLATILLO = 60d;
        final Integer TIEMPO_PLATILLO = 10;

        Platillo platillo = new Platillo();

        assertNotNull(platillo);
        assertNull(platillo.getNombre());
        assertNull(platillo.getPrecio());
        assertNull(platillo.getTiempoCoccion());
        assertNull(platillo.getProductos());

        platillo.setNombre(NOMBRE_PLATILLO);
        platillo.setPrecio(PRECIO_PLATILLO);
        platillo.setTiempoCoccion(TIEMPO_PLATILLO);
        platillo.setProductos(productos);

        assertEquals(NOMBRE_PLATILLO, platillo.getNombre());
        assertEquals(PRECIO_PLATILLO, platillo.getPrecio());
        assertEquals(TIEMPO_PLATILLO, platillo.getTiempoCoccion());
        assertEquals(productos, platillo.getProductos());
    }

    @Test
    @DisplayName("Debe crearse una nueva instancia con el constructor y sus parámetros")
    void constructorTest() {
        final String NOMBRE_PLATILLO = "Taco de Carne con Queso, Aguacate y Frijoles";
        final Double PRECIO_PLATILLO = 40d;
        final Integer TIEMPO_PLATILLO = 10;

        Platillo platillo1 = new Platillo(NOMBRE_PLATILLO, TIEMPO_PLATILLO, productos);

        assertNotNull(platillo1);
        assertEquals(NOMBRE_PLATILLO, platillo1.getNombre());
        assertEquals(TIEMPO_PLATILLO, platillo1.getTiempoCoccion());
        assertNull(platillo1.getPrecio());
        assertEquals(productos, platillo1.getProductos());

        Platillo platillo2 = new Platillo(NOMBRE_PLATILLO, TIEMPO_PLATILLO, productos, PRECIO_PLATILLO);

        assertNotNull(platillo2);
        assertEquals(NOMBRE_PLATILLO, platillo2.getNombre());
        assertEquals(PRECIO_PLATILLO, platillo2.getPrecio());
        assertEquals(TIEMPO_PLATILLO, platillo2.getTiempoCoccion());
        assertEquals(productos, platillo2.getProductos());
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
