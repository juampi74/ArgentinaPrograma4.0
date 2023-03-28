package org.argentinaprograma.Entidades;

import java.io.*;

public class CSVManage {

    public void writeCSV(String file, String alumno, String materia, String resultado){
        
    	try {
        	
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            
            printWriter.println(alumno + ";" + materia + ";" + resultado);

            printWriter.flush();
            printWriter.close();
            
        } catch (IOException e){
            System.out.println(e);
        }
    }

}
