package com.krakedev.jdbc.Clientes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.jdbc.Clientes.ClienteJdbc;

@Service
public class ServicioClienteJdbc {
	
	
	public Cliente crear(Cliente cliente) {
		return ClienteJdbc.insertar(cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getEdad());

	}

	public List<Cliente> listar() {
		return ClienteJdbc.listar();
	}

	public Cliente buscarPorCedula(String cedula) {
		return ClienteJdbc.buscar(cedula);

	}

	public Cliente actualizar(String cedula,Cliente clienteActualizado) {
		return ClienteJdbc.actualizar(cedula, clienteActualizado.getNombre(), clienteActualizado.getApellido(),
				clienteActualizado.getEdad());

	}
	public boolean eliminar(String cedula) {
		return ClienteJdbc.eliminar(cedula);
		
	}

}
