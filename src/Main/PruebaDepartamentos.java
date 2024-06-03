package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Conexion.Conexion_DB;

public class PruebaDepartamentos {
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
			resultado = sentencia.executeQuery("select cod_departamento, cod_centro,cod_director,tipo_dir,presupuesto,cod_dpto_jefe, nombre from departamentos");
			
			System.out.println("Cod. Departamento\tCod Centro\tCod Director\tTipo Dir\tPresupuesto\tCod Dpto Jefe\tNombre");
			// Paso 4. Recorrer el resultado
			while (resultado.next()) {
				int codDpto = resultado.getInt("cod_departamento");
				int codCentro = resultado.getInt("cod_centro");
				int codDirector = resultado.getInt("cod_director");
				String tipoDir = resultado.getString("tipo_dir");
				int presupuesto = resultado.getInt("presupuesto");
				int codDptoJefe = resultado.getInt("cod_dpto_jefe");
				String nombre = resultado.getString("nombre");
				
				
				System.out.println(codDpto + "\t\t\t"+ codCentro + "\t\t"+ codDirector + "\t\t"+ tipoDir + "\t\t"+ presupuesto + "\t\t" + codDptoJefe + "\t\t" + nombre );
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
