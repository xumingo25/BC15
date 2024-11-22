package bc15.gAcevedo.Unidad2.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
    private static Properties properties;

    public static String obtenerProperty(String key){
        String rutaArchivo = System.getProperty("user.dir")+"\\src\\test\\resources\\properties.properties";

        try{
            InputStream input = new FileInputStream(rutaArchivo);
            properties.load(input);
        } catch (Exception ex) {
            System.out.println("No se ha podido cargar el archivo properties . . ");
            System.out.println("Ruta: "+rutaArchivo);
            System.out.println(ex.getMessage());
        }
        return properties.getProperty(key);
    }
}
