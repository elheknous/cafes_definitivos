package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GestorDatos {

        public ArrayList<ArrayList<String>> leercsv(String ruta){
            ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
            Path filepath = Paths.get(ruta);
            try{
                BufferedReader br = Files.newBufferedReader(filepath);
                String linea;
                while ((linea = br.readLine()) != null){
                    String[] datosDeLinea = linea.split(",");
                    ArrayList<String> datosTemporal = new ArrayList<String>();
                    for (String dato : datosDeLinea){
                        datosTemporal.add(dato);
                    }
                    datos.add(datosTemporal);

                }
            } catch (IOException e ){
                e.printStackTrace();
            }
            return datos;
        }
        public void escribirCSV(String datos){
            File f = new File("./compra.csv");
            try (FileWriter fw = new FileWriter(f);){
                fw.write(datos);

            }catch (Exception e){
                System.out.println("error");
            }
        }

    }


