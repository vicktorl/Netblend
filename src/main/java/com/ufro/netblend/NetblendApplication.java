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

		// Peticiones
		List<Registro> ultimos10Usuarios = RegistroController.obtenerUltimos10Usuarios(registros);
		//List<Registro> usuariosPopulares = RegistroController.obtenerUsuariosPopulares(registros);
		//List<Registro> usuariosInactivosConMasSeguidores = obtenerUsuariosInactivosConMasSeguidores(registros);

		// Imprimir los resultados
		System.out.println("Últimos 10 usuarios que se han conectado más recientemente:");
		imprimirRegistros(ultimos10Usuarios);
		System.out.println();

		System.out.println("Usuario(s) más popular(es):");
		//imprimirRegistros(usuariosPopulares);
		System.out.println();

		System.out.println("Usuario(s) inactivo(s) con más seguidores:");
		//imprimirRegistros(usuariosInactivosConMasSeguidores);

	}
	public static void imprimirRegistros(List<Registro> registros) {
		for (Registro registro : registros) {
			System.out.println(registro);
		}}
}

