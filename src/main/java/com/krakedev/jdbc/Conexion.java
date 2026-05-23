package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
	private static final Logger log =LogManager.getLogger(InsertCliente.class);
	private static final String URL="jdbc:mysql://localhost:3306/mydb";
	private static final String USER="root";
	private static final String PASSWORD ="1004034391";
	//no se necessita instanciar una conexion
	public static Connection getConnection() {
		
		
		try {
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			log.info("conexion realizada");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("error en la conexion: " + e.getMessage());
			
			//propagamos la exepcion
			throw new RuntimeException("No se pudo conectar", e);
		}
		
	}

}
