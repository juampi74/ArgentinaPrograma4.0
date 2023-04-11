package org.argentinaprograma.qatar2022;

import static conexion.sql.ConectorSQL.*;

import java.sql.*;

public class App {
    
	public static void main(String[] args) {
        
		Connection conexion = null;
        Statement consulta = null;
        
        try {
        	
        	// Abrir la conexión
            System.out.println("Conectando a la base de datos...");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// Ejecutar Sentencias
			consulta = conexion.createStatement();
			String sql1 = "INSERT INTO departamento(nombre, presupuesto) VALUES(\"Logística\", 3000000), (\"Sistemas\", 4500000), (\"Compras\", 5000000), (\"Recursos Humanos\", 2500000)";
			consulta.executeUpdate(sql1);
			String sql2 = "INSERT INTO empleado(dni, nombre, apellido, nacionalidad, departamento_id) VALUES(24555769, \"Pedro\", \"Hernández\", \"Argentina\", 2), (39328731, \"Mariana\", \"Rodríguez\", \"Argentina\", 1)";
			consulta.executeUpdate(sql2);
			String sql3 = "UPDATE empleado SET nacionalidad = \"España\" WHERE id = 1";
			consulta.executeUpdate(sql3);
			String sql4 = "DELETE FROM departamento WHERE id = 4;";
			consulta.executeUpdate(sql4);
			
			
			// Ejecutar Consultas
			String sql5 = "SELECT * FROM empleado WHERE departamento_id = 1";
			String sql6 = "SELECT * FROM departamento ORDER BY nombre";
			
			
			ResultSet resultado5 = consulta.executeQuery(sql5);

			System.out.println("\n -------------------------------------------------------- ");
			System.out.println("  Empleados que trabajan en el departamento de Logistica");
			System.out.println(" -------------------------------------------------------- ");
			
			while(resultado5.next()) {
				int id = resultado5.getInt(1);
				int dni = resultado5.getInt(2);
				String nombre = resultado5.getString(3);
				String apellido = resultado5.getString(4);
				String nacionalidad = resultado5.getString(5);
				int departamento_id = resultado5.getInt(6);
				
				System.out.println(" | " + id + " | " + dni + " | " + nombre + " | " + apellido + " | " + nacionalidad + " | " + departamento_id + " | ");
			}
						
			
			ResultSet resultado6 = consulta.executeQuery(sql6);
			
			System.out.println("\n ----------------------------------------- ");
			System.out.println("  Departamentos ordenados alfabeticamente");
			System.out.println(" ----------------------------------------- ");
			
			while(resultado6.next()) {
				int id = resultado6.getInt(1);
				String nombre = resultado6.getString(2);
				int presupuesto = resultado6.getInt(3);
				
				System.out.println(" | " + id + " | " + nombre + " | " + nombre + " | " + presupuesto + " | ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    }
}
