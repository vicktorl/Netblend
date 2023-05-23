package com.ufro.netblend;

import com.ufro.netblend.controller.RegistroController;
import com.ufro.netblend.models.Registro;
import org.springframework.stereotype.Controller;
import utils.CSV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class NetblendApplication {



	public static void main(String[] args) {
		SpringApplication.run(NetblendApplication.class, args);
		CSV nuevoCSV = new CSV();
		RegistroController  peticiones = new RegistroController();
		List<Registro> registros = nuevoCSV.leerArchivo(); // Obtener la lista de registros desde el método leerArchivo()

	/*	List<Registro> ultimos10Usuarios = peticiones.obtenerUltimos10Usuarios(registros);
		// Imprimir los resultados
		System.out.println("Últimos 10 usuarios que se han conectado más recientemente:");
		peticiones.imprimirRegistros(ultimos10Usuarios);
		System.out.println();
*/
	}
}

