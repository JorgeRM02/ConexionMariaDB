package Main;

import java.sql.Connection;

import Conexion.Conexion_DB;

public class Main {
	public static void main(String[] args) {
		Conexion_DB conexion = new Conexion_DB();
		System.out.println("Conectando a la base de datos...");
		
		Connection con =conexion.getConnection();
		
		// Algún procesamiento con la base de datos..
		
		// Liberamos la conexion 
		conexion.desconectar();
		
	}
}
