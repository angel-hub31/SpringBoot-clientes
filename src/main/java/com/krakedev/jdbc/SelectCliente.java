package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// trae toda los datos de la base de datos creada
public class SelectCliente {
	private static final Logger log = LogManager.getLogger(SelectCliente.class);

	public static void main(String[] args) {

		// creamos una varible de tipo conecxion, lo iniciamos como null
		Connection con = null;
		// vamos a utilizar codigo sql con :PreparedStatement guarda este codigo
		// sql previamente preparado, lo iniciamos como null
		PreparedStatement ps = null;
		// ResultSet guarda las filas devueltas o importadas por el select
		ResultSet rs = null;

		try {
			// llamamos a nuestro metodo Connection de nuestra clase Conexion
			// y llamamos al metodo statico
			con = Conexion.getConnection();

			String sql = """
					SELECT * FROM Client
					""";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			//recorremos con el while que nos devuelve V o F en funcion de si hay mas filas
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");

				log.info("Cliente: Cedula: " + cedula + " Nombre: " + nombre + " Apellido: " + apellido + " Edad: "
						+ edad);

			}

		} catch (Exception e) {
			log.error("error al traer datos",e.getMessage());

		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
