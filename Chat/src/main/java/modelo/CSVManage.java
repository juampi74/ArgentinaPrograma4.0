package modelo;

import java.io.*;

public class CSVManage {

    public void writeCSV(String file, String nombre, String mensaje){
        
    	try {
        	
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            
            printWriter.println(nombre + ";" + mensaje);

            printWriter.flush();
            printWriter.close();
            
        } catch (IOException e){
            System.out.println(e);
        }
    }

}
