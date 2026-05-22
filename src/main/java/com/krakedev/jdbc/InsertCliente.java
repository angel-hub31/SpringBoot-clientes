package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// inserta un cliente en la base de datos
public class InsertCliente {
	
	private static final Logger log =LogManager.getLogger(InsertCliente.class);
	private static final String URL="jdbc:postgresql://localhost:5432/postgres";
	private static final String USER="postgres";
	private static final String PASSWORD ="1004034391";
	
	public static void main(String[] args) {
   //primero nos conectamos con la base de datos
		Connection con =null;
		//representa una sentencia sql preparada
		PreparedStatement ps;
		//sentencia sql
		String sql=""" 
				INSERT INTO  Client(cedula, nombre, apellido, edad)
				VALUES(?,?,?,?)
				""";	
		
		
		
		
		try {
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			ps=con.prepareStatement(sql);
			//seteamos la primera columna, en este caso es la columna cedula
			ps.setString(1, "1004034381");
			//seteamos la segunda columna, en este caso es la columna nombre
			ps.setString(2, "Angel");
			//seteamos la tercera columna, en este caso es la columna apellido
			ps.setString(3, "Morales");
			//seteamos la cuarta columna, en este caso es la columna edad
			ps.setInt(4, 31);
			
			//devuelve las filas aafectadas filas fueron afectadas
			int filas=ps.executeUpdate();
			
			log.info("conexion exitosa");
			log.info("Filas insertadas: "+ filas);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("error en la conexion: " + e.getMessage());;
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
