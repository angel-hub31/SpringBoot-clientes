package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

public class ServicioClienteTest {

    // =========================
    // TEST CREAR
    // =========================
    @Test
    public void testCrearCliente() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente c = new Cliente();
        c.setCedula("123");
        c.setNombre("Juan");
        c.setApellido("Perez");
        c.setEdad(15);

        Cliente resultado = servicio.crear(c);

        assertNotNull(resultado);
        assertEquals("123", resultado.getCedula());
        assertEquals(15, resultado.getEdad());
    }

    @Test
    public void testCrearClienteDuplicado() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente c1 = new Cliente();
        c1.setCedula("123");
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setEdad(31);

        Cliente c2 = new Cliente();
        c2.setCedula("123");
        c2.setNombre("Pedro");
        c2.setApellido("Lopez");
        c2.setEdad(19);

        servicio.crear(c1);
        Cliente resultado = servicio.crear(c2);

        assertNull(resultado);
    }

    // =========================
    // TEST BUSCAR
    // =========================
    @Test
    public void testBuscarPorCedulaExistente() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente c = new Cliente();
        c.setCedula("123");
        c.setNombre("Juan");
        c.setApellido("Perez");
        c.setEdad(15);

        servicio.crear(c);

        Cliente resultado = servicio.buscarPorCedula("123");

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        assertEquals(15, resultado.getEdad());
    }

    @Test
    public void testBuscarPorCedulaNoExistente() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente resultado = servicio.buscarPorCedula("999");

        assertNull(resultado);
    }

    // =========================
    // TEST LISTAR
    // =========================
    @Test
    public void testListar() {
        ServicioCliente servicio = new ServicioCliente();
        int tamanioInicial = servicio.Listar().size();

        Cliente c1 = new Cliente();
        c1.setCedula("123");
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setEdad(18);

        Cliente c2 = new Cliente();
        c2.setCedula("456");
        c2.setNombre("Maria");
        c2.setApellido("Lopez");
        c2.setEdad(24);

        servicio.crear(c1);
        servicio.crear(c2);

        assertEquals(tamanioInicial + 2, servicio.Listar().size());
    }

    // =========================
    // TEST ACTUALIZAR
    // =========================
    @Test
    public void testActualizarClienteExistente() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente c = new Cliente();
        c.setCedula("123");
        c.setNombre("Juan");
        c.setApellido("Perez");
        c.setEdad(30);

        servicio.crear(c);

        Cliente actualizado = new Cliente();
        actualizado.setNombre("Juan Carlos");
        actualizado.setApellido("Gomez");
        actualizado.setEdad(22);

        Cliente resultado = servicio.actualizar("123", actualizado);

        assertNotNull(resultado);
        assertEquals("Juan Carlos", resultado.getNombre());
        assertEquals("Gomez", resultado.getApellido());
        assertEquals(22, resultado.getEdad());
    }

    @Test
    public void testActualizarClienteNoExistente() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente actualizado = new Cliente();
        actualizado.setNombre("Nuevo");
        actualizado.setApellido("Apellido");
        actualizado.setEdad(20);

        Cliente resultado = servicio.actualizar("999", actualizado);

        assertNull(resultado);
    }

    // =========================
    // TEST ELIMINAR
    // =========================
    @Test
    public void testEliminarClienteExistente() {
        ServicioCliente servicio = new ServicioCliente();

        Cliente c = new Cliente();
        c.setCedula("123");
        c.setNombre("Juan");
        c.setApellido("Perez");
        c.setEdad(33);

        servicio.crear(c);

        boolean resultado = servicio.eliminar("123");

        assertTrue(resultado);
        assertNull(servicio.buscarPorCedula("123"));
    }

    @Test
    public void testEliminarClienteNoExistente() {
        ServicioCliente servicio = new ServicioCliente();

        boolean resultado = servicio.eliminar("999");

        assertFalse(resultado);
    }
    
}