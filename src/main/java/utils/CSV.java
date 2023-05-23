package utils;

import com.ufro.netblend.models.Registro;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CSV {
    //Codigo para leer el csv
    public ArrayList<Registro> Registros = new ArrayList<Registro>();
    public void leerArchivo(){

        Registro Registro;
        String[] datos;
        int cont=0;
        try (Scanner scFile = new Scanner(new File("src\\main\\java\\utils\\dataset2.csv"))){
            while (scFile.hasNextLine()) {

                datos = scFile.nextLine().split(";");
                if (cont>0){
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Registro = new Registro(Integer.parseInt(datos[0]),datos[1],formato.parse(datos[2]),
                            new ArrayList<>());
                    String siguiendoString = datos[3]; // Obtén la cadena de valores
                    String[] siguiendoArray = siguiendoString.split(","); // Divide la cadena en un arreglo de valores separados por comas

                    // Convierte los valores del arreglo a enteros y agrégalos a la lista siguiendo
                    for (String valor : siguiendoArray) {
                        int siguiendo = Integer.parseInt(valor.trim()); // Convierte el valor a entero
                        Registro.getSiguiendo().add(siguiendo); // Agrega el valor a la lista siguiendo
                    }
                    Registros.add(Registro);
                }cont++;}
        }catch(Exception e){
            System.out.println(e);
        }
        imprimirProducto(Registros);
    }

    public void imprimirProducto(ArrayList<Registro> Registros) {
        for (Registro Registro : Registros) {
            System.out.println(Registro);
        }

    }
}