package com.krakedev.exepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckendExepciones {

	public static void main(String[] args) {
		
		System.out.println("Inicia el programa ");
		
		try {
			FileReader  archivo = new FileReader ("archivo.txt");
			System.out.println("Archivo abierto");
			
		}catch (FileNotFoundException e) {
			
			System.out.println("Error el archivo no fue encontrado: "+ e.getMessage());
			e.printStackTrace();
		}
	}

}
