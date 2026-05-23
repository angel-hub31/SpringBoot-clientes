package com.krakedev.empleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.empleados.entidades.Empleado;
import com.krakedev.empleados.repository.EmpleadoRepository;

@Service
public class ServicioEmpleado {

	private final EmpleadoRepository repository;

// generamos el constructor
	public ServicioEmpleado(EmpleadoRepository repository) {

		this.repository = repository;
	}

	public Empleado crear(Empleado empleado) {
		return repository.save(empleado);

	}

	public List<Empleado> listar() {
		return repository.findAll();
	}

	public Empleado buscarPorId(Long id) {
		Optional<Empleado> resultado = repository.findById(id);
		return resultado.orElse(null);
	}

	public Empleado actualizar(Long id, Empleado empleadoActualizado) {
		Empleado empleado = buscarPorId(id);

		if (empleado == null) {
			return null;

		}
		empleado.setNombre(empleadoActualizado.getNombre());
		empleado.setApellido(empleadoActualizado.getApellido());
		empleado.setCargo(empleadoActualizado.getCargo());
		empleado.setSalario(empleadoActualizado.getSalario());
		empleado.setActivo(empleadoActualizado.isActivo());

		return repository.save(empleado);

	}
	public boolean eliminar(Long id) {
		Empleado empleado = buscarPorId(id);

		if (empleado == null) {
			return false;
			

		}
		repository.deleteById(id);
		return true;
		
	}
	public List<Empleado> buscarPorCargo(String cargo){
		return repository.findByCargo(cargo);
		
	}
	
	public List<Empleado> buscarPorEstado(boolean estado){
		return repository.findByActivo(estado);
		
	}
}
