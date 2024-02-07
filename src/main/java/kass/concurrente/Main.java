package kass.concurrente;

import kass.concurrente.modelo.cuchillo.Cuchillo;
import kass.concurrente.modelo.cuchillo.CuchilloFactory;
import kass.concurrente.modelo.cuchillo.TipoCuchillo;
import kass.concurrente.modelo.persona.Chef;
import kass.concurrente.modelo.persona.Cliente;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Clase Main
 * Aqui va toda tu simulacion
 * Genera un par de clientes para que los atienda el chef
 * 
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Chef que va a cocinar
        Cuchillo cuchillo = CuchilloFactory.obtenerCuchillo(TipoCuchillo.JADE);
        Chef chef = Chef.builder().setNombre("Gordon Ramsay").setEdad(47).setCuchillo(cuchillo).build();

        // Inventario disponible
        List<ProductoInventario> inventario = crearInventario();

        // Platillos disponibles en el restaurante
        List<Platillo> platillos = crearPlatillos(inventario);

        // Clientes
        List<Cliente> clientes = crearClientes(platillos);

        Double ganancia = 0d;

        System.out.println("Abriendo el restaurante");

        // Atentiendo a cada cliente
        for (Cliente cliente : clientes) {
            System.out.println("\n---Chef " + chef.getNombre() + " atendiendo a " + cliente.getNombre()
                    + "---");

            // Cocinando cada platillo de la orden del cliente
            for (Platillo platillo : cliente.getOrden()) {
                System.out.println("\nCocinando " + platillo.getNombre());
                Integer tiempoCoccion = platillo.getTiempoCoccion() - chef.getCuchillo().corta();
                System.out.println(
                        "El platillo tarda " + platillo.getTiempoCoccion()
                                + " unidades de tiempo en prepararse");
                System.out.println(
                        "Pero el Chef tiene un cuchillo que ahorra "
                                + chef.getCuchillo().corta() + " unidades de tiempo");

                // Descontando los ingredientes del inventario
                for (Producto ingrediente : platillo.getProductos()) {
                    Optional<ProductoInventario> resultado = inventario.stream()
                            .filter(x -> x.getNombre().equals(ingrediente.getNombre())).findFirst();

                    if (resultado.isEmpty()) {
                        throw new InterruptedException();
                    }

                    ProductoInventario producto = resultado.get();

                    // Ya no tenemos inventario de dicho ingrediente
                    if (producto.getCantidad() == 0) {
                        System.out.println("Oh oh... ya no tenemos " + producto.getNombre()
                                + " en el inventario por lo que el Chef traerá más y tardará 2 unidades de tiempo");

                        producto.setCantidad(3);

                        tiempoCoccion += 2;
                    }

                    producto.setCantidad(producto.getCantidad() - 1);
                }

                System.out.println(
                        "Por lo tanto el tiempo de preparación es de " + tiempoCoccion
                                + " unidades de tiempo");

                Thread.sleep(tiempoCoccion * 1000l);

                ganancia += platillo.calculaPrecio();
            }
        }

        System.out.println("\nLa ganancia total fue de: $" + ganancia);
    }

    private static List<ProductoInventario> crearInventario() {
        return new LinkedList<>(Arrays.asList(
                ProductoInventario.builder().setNombre("Jitomate").setCantidad(1).setPrecio(2d)
                        .build(),
                ProductoInventario.builder().setNombre("Fideos").setCantidad(1).setPrecio(5d).build(),
                ProductoInventario.builder().setNombre("Espinaca").setCantidad(1).setPrecio(3.5)
                        .build(),
                ProductoInventario.builder().setNombre("Zanahoria").setCantidad(1).setPrecio(1.5)
                        .build(),
                ProductoInventario.builder().setNombre("Calabacitas").setCantidad(1).setPrecio(1.5)
                        .build(),
                ProductoInventario.builder().setNombre("Chicharos").setCantidad(1).setPrecio(1d)
                        .build(),
                ProductoInventario.builder().setNombre("Jamón").setCantidad(1).setPrecio(10d).build(),
                ProductoInventario.builder().setNombre("Crema ácida").setCantidad(1).setPrecio(8d)
                        .build(),
                ProductoInventario.builder().setNombre("Arroz").setCantidad(1).setPrecio(5.5).build(),
                ProductoInventario.builder().setNombre("Tomate verde").setCantidad(1).setPrecio(3.5)
                        .build(),
                ProductoInventario.builder().setNombre("Cebolla").setCantidad(1).setPrecio(2.5)
                        .build(),
                ProductoInventario.builder().setNombre("Pollo deshebrado").setCantidad(1)
                        .setPrecio(15d)
                        .build(),
                ProductoInventario.builder().setNombre("Pollo en bistec").setCantidad(1).setPrecio(20d)
                        .build(),
                ProductoInventario.builder().setNombre("Pan molido").setCantidad(1).setPrecio(10d)
                        .build(),
                ProductoInventario.builder().setNombre("Huevo").setCantidad(1).setPrecio(3.5).build(),
                ProductoInventario.builder().setNombre("Chile Serrano").setCantidad(1).setPrecio(0.5)
                        .build(),
                ProductoInventario.builder().setNombre("Lechuga").setCantidad(1).setPrecio(5d).build(),
                ProductoInventario.builder().setNombre("Pepino").setCantidad(1).setPrecio(8d).build(),
                ProductoInventario.builder().setNombre("Limon").setCantidad(1).setPrecio(5.5).build(),
                ProductoInventario.builder().setNombre("Aguacate").setCantidad(1).setPrecio(13d)
                        .build(),
                ProductoInventario.builder().setNombre("Spaguetti").setCantidad(1).setPrecio(5.5)
                        .build(),
                ProductoInventario.builder().setNombre("Tortilla").setCantidad(1).setPrecio(2d)
                        .build()));
    }

    private static List<Platillo> crearPlatillos(List<ProductoInventario> inventario) {
        return new LinkedList<>(
                Arrays.asList(Platillo.builder().setNombre("Sopa de Pasta").setTiempoCoccion(5)
                        .setProductos(Arrays.asList(inventario.get(0), inventario.get(1)))
                        .build(),
                        Platillo.builder().setNombre("Sopa de verduras").setTiempoCoccion(5)
                                .setProductos(Arrays.asList(inventario.get(2),
                                        inventario.get(3), inventario.get(4)))
                                .build(),
                        Platillo.builder().setNombre("Arroz a la mexicana").setTiempoCoccion(8)
                                .setProductos(Arrays.asList(inventario.get(8),
                                        inventario.get(0)))
                                .build(),
                        Platillo.builder().setNombre("Spaguetti blanco").setTiempoCoccion(4)
                                .setProductos(Arrays.asList(inventario.get(20),
                                        inventario.get(6), inventario.get(7)))
                                .build(),
                        Platillo.builder().setNombre("Enchiladas").setTiempoCoccion(12)
                                .setProductos(
                                        Arrays.asList(inventario.get(9),
                                                inventario.get(10),
                                                inventario.get(21),
                                                inventario.get(11)))
                                .build(),
                        Platillo.builder().setNombre("Pechuga de pollo empanizada con ensalada")
                                .setTiempoCoccion(10)
                                .setProductos(Arrays.asList(inventario.get(12),
                                        inventario.get(13), inventario.get(16),
                                        inventario.get(17), inventario.get(18),
                                        inventario.get(19)))
                                .build(),
                        Platillo.builder().setNombre("Tacos dorados de pollo con ensalada")
                                .setTiempoCoccion(8)
                                .setProductos(Arrays.asList(inventario.get(11),
                                        inventario.get(21), inventario.get(16),
                                        inventario.get(17), inventario.get(18),
                                        inventario.get(19)))
                                .build()));
    }

    private static List<Cliente> crearClientes(List<Platillo> platillos) {
        return new LinkedList<>(Arrays.asList(
                Cliente.builder().setNombre("Samantha Martinez").setEdad(22).setOrden(Arrays.asList(
                        platillos.get(0), platillos.get(3), platillos.get(6))).build(),
                Cliente.builder().setNombre("Gabriel Velazquez").setEdad(22).setOrden(Arrays.asList(
                        platillos.get(1), platillos.get(2), platillos.get(5))).build(),
                Cliente.builder().setNombre("Natalia Velazquez").setEdad(22).setOrden(Arrays.asList(
                        platillos.get(0), platillos.get(2), platillos.get(4))).build(),
                Cliente.builder().setNombre("Leonardo Espetia").setEdad(22).setOrden(Arrays.asList(
                        platillos.get(1), platillos.get(3), platillos.get(5))).build()));
    }
}