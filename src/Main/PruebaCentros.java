package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.Conexion_DB;

public class PruebaCentros {
	public static void main(String[] args) {
		Conexion_DB conexion = new Conexion_DB();
		// Paso 1. Obtener la conexion
		Connection con =conexion.getConnection();
		
		// Objetos necesarios para hacer una consulta
		Statement sentencia =null;
		ResultSet resultado = null;
		
		System.out.println("Conectando a la base de datos...");
		
		// Algún procesamiento con la base de datos..
		try {
			// Paso 2. Obtener el Statement
			sentencia = con.createStatement();
			
			// Paso 3. Ejecutar la sentencia
			resultado = sentencia.executeQuery("select cod_centro, nombre, direccion from centros");
			
			System.out.println("Cod. Centro\tNombre\t\t\tDireccion");
			// Paso 4. Recorrer el resultado
			while (resultado.next()) {
				int codCentro = resultado.getInt("cod_centro");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				
				System.out.println(codCentro + "\t\t"+ nombre + "\t\t"+ direccion);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar datos" + e.getMessage());
		}
		finally{
			try {
				resultado.close();
				sentencia.close();
			} catch (SQLException e) {
				// Error al liberar recursos
			}
		}
		
		// Liberamos la conexion  
		conexion.desconectar();
		
	}
}
