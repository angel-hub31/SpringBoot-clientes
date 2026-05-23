package com.krakedev.empleados.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.empleados.entidades.Empleado;
import com.krakedev.empleados.services.ServicioEmpleado;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	private final ServicioEmpleado servicio;

	// constructor
	public EmpleadoController(ServicioEmpleado servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Empleado empleado) {

		try {
			Empleado creado = servicio.crear(empleado);
			return ResponseEntity.status(HttpStatus.CREATED).body(creado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear empleado");

		}

	}

	@GetMapping
	public ResponseEntity<?> listar() {

		try {
			List<Empleado> empleados = servicio.listar();
			return ResponseEntity.ok(empleados);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar empleado");

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {

		try {
			Empleado empleado = servicio.buscarPorId(id);

			if (empleado == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("El empleado con la Id : " + id + "  no fue encontrado");

			}
			return ResponseEntity.ok(empleado);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar empleado");

		}

	}
	@GetMapping("/cargo")
	public ResponseEntity<?> buscarPorCargo(@RequestParam String cargo){
		
		try {
			List<Empleado> empleados =servicio.buscarPorCargo(cargo);
			return ResponseEntity.ofNullable(empleados);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por cargo");

			
		}
		
	}
	
	@GetMapping("/estado")
	public ResponseEntity<?> buscarPorEstado(@RequestParam boolean estado){
		
		try {
			List<Empleado> empleados =servicio.buscarPorEstado(estado);
			return ResponseEntity.ofNullable(empleados);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por estado");

			
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Empleado empleado){
		try {
			Empleado actualizado =servicio.actualizar(id, empleado);
			if(actualizado == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("El empleado con la Id : " + id + "  no fue encontrado");

				
			}
			return ResponseEntity.ok(actualizado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar");

		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		try {
			
			boolean eliminado=servicio.eliminar(id);
			
			if(!eliminado) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("El empleado con la Id : " + id + "  no fue encontrado");

				
			}
			return ResponseEntity.ok("Empleado eliminado con exito");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar");

			
		}
		
		
	}
	
	

}
