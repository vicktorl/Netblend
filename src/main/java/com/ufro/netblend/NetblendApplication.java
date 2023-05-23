package com.ufro.netblend;

import utils.CSV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetblendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetblendApplication.class, args);
		CSV nuevoCSV = new CSV();
		nuevoCSV.leerArchivo();
	}

}
