package com.krakedev.exepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class PropagacionDeError {
	public void metodoA() throws FileNotFoundException {
		FileReader  archivo = new FileReader ("archivo.txt");
		System.out.println("Archivo abierto");
		
	}
	public void metodoB() {
		try {
			metodoA();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
