package com.ufro.netblend;

import com.ufro.netblend.controller.RegistroController;
import com.ufro.netblend.models.Registro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.CSV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
@RestController
public class NetblendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetblendApplication.class, args);
	}

	@GetMapping("/ultimos-usuarios")
	public List<Registro>  realizarPeticiones() {
		CSV nuevoCSV = new CSV();
		List<Registro> registros = nuevoCSV.leerArchivo();

		registros.sort(Comparator.comparing(Registro::getUltima_conexion).reversed()); // Ordenar por fecha de última conexión en orden descendente
		return registros.subList(0, Math.min(registros.size(), 10));
	}
	@GetMapping("/usuarios-populares")
	// Obtener el/los usuario(s) más popular(es)
	private static List<Registro> obtenerUsuariosPopulares() {
		CSV nuevoCSV = new CSV();
		List<Registro> registros = nuevoCSV.leerArchivo();
		int maxSeguidores = 0;
		List<Registro> usuariosPopulares = new ArrayList<>();

		for (Registro registro : registros) {
			int cantidadSeguidores = registro.getSiguiendo().size();

			if (cantidadSeguidores > maxSeguidores) {
				maxSeguidores = cantidadSeguidores;
				usuariosPopulares.clear();
				usuariosPopulares.add(registro);
			} else if (cantidadSeguidores == maxSeguidores) {
				usuariosPopulares.add(registro);
			}
		}

		return usuariosPopulares;
	}


	@GetMapping("/usuarios-inactivos")
	private static List<Registro> obtenerUsuariosInactivosConMasSeguidores() {
		CSV nuevoCSV = new CSV();
		List<Registro> registros = nuevoCSV.leerArchivo();
		Date fechaActual = new Date();
		Date fechaInactividad = restarDias(fechaActual, 730); // Restar 730 días a la fecha actual que es

		int maxSeguidores = 0;
		for (Registro registro : registros) {
			if (registro.getUltima_conexion().before(fechaInactividad) && registro.getSiguiendo().size() > maxSeguidores) {
				maxSeguidores = registro.getSiguiendo().size();
			}
		}

		List<Registro> usuariosInactivosConMasSeguidores = new ArrayList<>();
		for (Registro registro : registros) {
			if (registro.getUltima_conexion().before(fechaInactividad) && registro.getSiguiendo().size() == maxSeguidores) {
				usuariosInactivosConMasSeguidores.add(registro);
			}
		}

		return usuariosInactivosConMasSeguidores;
	}
	// Restar días a una fecha
	private static Date restarDias(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, -dias);
		return calendar.getTime();
	}
}
