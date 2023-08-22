
package tallerproductosdb;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author diazje
 */
public class ConexionDB {
    
    private final String base = "baseproductos";
    private final String user = "root";
    private final String password = "";

    // Define la URL de conexión a la base de datos. Si en algún caso se usa MySQL, se debe cambiar el inicio de la URL.
    private final String url = "jdbc:mariadb://localhost:3306/" + base;
    // Declara una variable para la conexión
    private Connection con = null;
    
    public Connection getConexion() {
        try {
            // Intenta cargar el driver de MariaDB en memoria. Si se usase MySQL, se tendría que cargar el driver correspondiente.
            Class.forName("org.mariadb.jdbc.Driver");
            
            // Establece la conexión usando los detalles definidos anteriormente y la asigna a la variable con
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexion establecida");
        } catch(SQLException e) {
            // En caso de un error SQL, imprime el error
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            // En caso de que no se encuentre el driver, se registra el error con un logger
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retorna la conexión establecida o null en caso de que no se haya podido conectar
        return con;        
    }   
    
}
