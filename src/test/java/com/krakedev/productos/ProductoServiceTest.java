package com.krakedev.productos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.productos.entidades.Producto;
import com.krakedev.productos.service.ProductoService;

public class ProductoServiceTest {

    @Test
    public void testCrearProductoExitoso() {

        // Se espera que el producto se cree correctamente
        ProductoService service = new ProductoService();

        Producto producto = new Producto("Laptop", 1, 2500.0, 10);

        Producto resultado = service.crear(producto);

        assertEquals(producto, resultado);
        assertEquals(1, service.listar().size());
    }

    @Test
    public void testCrearProductoDuplicado() {

        // Se espera que no permita crear productos con el mismo codigo
        ProductoService service = new ProductoService();

        Producto producto1 = new Producto("Mouse", 2, 25.0, 20);
        Producto producto2 = new Producto("Teclado", 2, 40.0, 15);

        service.crear(producto1);

        Producto resultado = service.crear(producto2);

        assertNull(resultado);
        assertEquals(1, service.listar().size());
    }

    @Test
    public void testBuscarProductoExistente() {

        // Se espera encontrar el producto por codigo
        ProductoService service = new ProductoService();

        Producto producto = new Producto("Monitor", 3, 300.0, 5);

        service.crear(producto);

        Producto encontrado = service.buscarPorCodigo(3);

        assertEquals(producto, encontrado);
    }

    @Test
    public void testBuscarProductoNoExistente() {

        // Se espera retornar null si el producto no existe
        ProductoService service = new ProductoService();

        Producto encontrado = service.buscarPorCodigo(100);

        assertNull(encontrado);
    }

    @Test
    public void testEliminarProducto() {

        // Se espera eliminar correctamente el producto
        ProductoService service = new ProductoService();

        Producto producto = new Producto("Impresora", 4, 150.0, 3);

        service.crear(producto);

        boolean eliminado = service.eliminar(4);

        assertTrue(eliminado);
        assertEquals(0, service.listar().size());
    }

    @Test
    public void testActualizarProductoExistente() {

        // Se espera actualizar nombre, precio y stock del producto
        ProductoService service = new ProductoService();

        Producto producto = new Producto("Tablet", 5, 400.0, 8);

        service.crear(producto);

        Producto actualizado = new Producto("Tablet Pro", 5, 550.0, 12);

        Producto resultado = service.actualizar(5, actualizado);

        assertEquals("Tablet Pro", resultado.getNombre());
        assertEquals(550.0, resultado.getPrecio());
        assertEquals(12, resultado.getStock());
    }

    @Test
    public void testActualizarProductoNoExistente() {

        // Se espera retornar null si el producto no existe
        ProductoService service = new ProductoService();

        Producto actualizado = new Producto("Celular", 6, 900.0, 7);

        Producto resultado = service.actualizar(6, actualizado);

        assertNull(resultado);
    }

    @Test
    public void testEliminarProductoNoExistente() {

        // Se espera retornar false si el producto no existe
        ProductoService service = new ProductoService();

        boolean eliminado = service.eliminar(999);

        assertFalse(eliminado);
    }
}