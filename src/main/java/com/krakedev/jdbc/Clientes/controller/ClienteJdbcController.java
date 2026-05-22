package com.krakedev.jdbc.Clientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;
import com.krakedev.jdbc.Clientes.services.ServicioClienteJdbc;

@RestController
@RequestMapping("/jdbc/clientes")
public class ClienteJdbcController {

	private final ServicioClienteJdbc servicio;

	public ClienteJdbcController(ServicioClienteJdbc servicio) {

		this.servicio = servicio;
	}
//mapear crear Cliente
	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return servicio.crear(cliente);
	}
	
	//
	@GetMapping
	public List<Cliente>listar(){
		return servicio.listar();
		
	}
	@GetMapping("/{cedula}")
	public Cliente buscar(@PathVariable String cedula) {
		return servicio.buscarPorCedula(cedula);
		
	}
	
	@PutMapping("/{cedula}")
	public Cliente actualizar(@PathVariable String cedula,@RequestBody Cliente cliente) {
		return servicio.actualizar(cedula, cliente);
	}
	
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicio.eliminar(cedula);
	}
}
