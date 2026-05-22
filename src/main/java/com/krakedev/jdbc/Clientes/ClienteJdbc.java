package com.krakedev.jdbc.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.jdbc.Conexion;

public class ClienteJdbc {
	private static final Logger log = LogManager.getLogger(ClienteJdbc.class);

	// metodo crear cliente : retorna un objeto de tipo cliente
	public static Cliente insertar(String cedula, String nombre, String apellido, int edad) {
		Connection con = null;
		PreparedStatement ps = null;
		Cliente cliente = null;

		try {
			con = Conexion.getConnection();

			String sql = "INSERT INTO Client (cedula, nombre, apellido,edad) VALUES (?,?,?,?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, cedula);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setInt(4, edad);

			cliente = new Cliente(cedula, nombre, apellido, edad);
			int filas = ps.executeUpdate();
			log.info("Filas insertadas: " + filas);

		} catch (Exception e) {
			log.error("Error al insertar: ", e);

		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return cliente;
	}

	// metodo listar clientes
	public static List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<>();
		Connection con = null;
		try {
			con = Conexion.getConnection();

			String sql = "SELECT * FROM Client";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("edad"));

				clientes.add(c);

			}

		} catch (Exception e) {
			log.error("Error al listar: ", e);

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return clientes;

	}

	// metodo: buscar por cedula
	public static Cliente buscar(String cedula) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "SELECT * FROM Client WHERE cedula=?";
		ResultSet rs = null;
		Cliente cliente = null;

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, cedula);
			rs = ps.executeQuery();

			if (rs.next()) {
				cliente = new Cliente(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("edad"));

			}

		} catch (Exception e) {
			log.error("Error al buscar por cedula: ", e);

		} finally {
		    try {
		        if (con != null) {
		            con.close();
		        }
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		}
		return cliente;
	}

	// metodo actualizar
	public static Cliente actualizar(String cedula, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE Client SET nombre=?, apellido=?,edad=? WHERE cedula=?";
		ResultSet rs = null;
		Cliente cliente = null;

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, nuevoNombre);
			ps.setString(2, nuevoApellido);
			ps.setInt(3, nuevaEdad);
			ps.setString(4, cedula);

			int fila = ps.executeUpdate();
			cliente = new Cliente(cedula, nuevoNombre, nuevoApellido, nuevaEdad);

		} catch (Exception e) {
			log.error("error al actualizar: ", e);
		} finally {
			try {
				if(con !=null) {
					con.close();

				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cliente;
	}

	public static boolean eliminar(String cedula) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM Client WHERE cedula=?";
		ResultSet rs = null;

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, cedula);
			int fila = ps.executeUpdate();
			return true;

		} catch (Exception e) {
			log.error("error al eliminar: ", e);

			return false;

		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
