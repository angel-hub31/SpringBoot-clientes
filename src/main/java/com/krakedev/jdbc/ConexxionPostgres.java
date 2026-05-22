package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexxionPostgres {

	private static final Logger log = LogManager.getLogger(ConexxionPostgres.class);

	public static void main(String[] args) {

		// conexion con postgres
		
		Connection con=null;
		
		try {
			con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1004034391");
			log.info("conexion exitosa");
		} catch (SQLException e) {
			
			log.error("error de conexion: " + e.getMessage());
			
			//cerramos la conexion
		}finally {
			try {
				con.close();
			}catch(SQLException e){
				log.error("error de conexion: " + e.getMessage());
				
			}
			
			
		}

	}

}
