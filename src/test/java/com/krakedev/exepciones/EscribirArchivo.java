package com.krakedev.exepciones;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EscribirArchivo {
	
	
	private static final Logger log = LogManager.getLogger(EscribirArchivo.class); 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileWriter escritor =new  FileWriter ("contacto.txt",true);
			escritor.write("Carlos\n");
			escritor.write("Castillos\n");
			escritor.write("123456781\n");
			//cerramos
			escritor.close();
			
			log.info("Archivo creado con exito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Ocurrio un eror" , e.getMessage());
		}
		

	}

}
