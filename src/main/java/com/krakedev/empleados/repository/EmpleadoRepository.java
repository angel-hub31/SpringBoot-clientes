package com.krakedev.empleados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.empleados.entidades.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
	
	List<Empleado> findByCargo(String cargo);
	
	List<Empleado> findByActivo(boolean activo);

}
