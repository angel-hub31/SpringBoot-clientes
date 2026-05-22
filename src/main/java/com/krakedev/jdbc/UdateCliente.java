package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UdateCliente {
	private static final Logger log = LogManager.getLogger(UdateCliente.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con= null;
		PreparedStatement ps = null;
		
		try {
			con=Conexion.getConnection();
			String sql="""
					UPDATE Client SET nombre=?,apellido=?,edad=? 
					WHERE cedula=?
					""";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1,"Ivan" );
			ps.setString(2,"Lopez" );
			ps.setInt(3, 15);
			ps.setString(4, "1004034391");
			
			int fila=ps.executeUpdate();
			log.info("filas afectadas: " + fila);
			//capturamos la exepcion
		}catch(Exception e){
			log.error("Error al actualizar: " +e.getMessage());
			
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
