
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dataSource.SistemConec;

/**
 * @author AdeS
 */
public class ProfesorDAO {
    private Connection connP;
    private Statement st;
    private ResultSet rs;
    
    private static ProfesorDAO instance;
    
    public ProfesorDAO() throws FileNotFoundException, IOException{
        try {
            String url = "jdbc:mysql://localhost:3306/pruebaxxx";
            FileInputStream fis = new FileInputStream(SistemConec.FILEDBCONFIG);
            Properties prop = new Properties();
            prop.load(fis);
            this.connP = DriverManager.getConnection(url, prop);
            if (connP != null) {
                System.out.println("CONEXION EXITOSA A PEPA: " + connP.getCatalog());
            }
        } catch (SQLException ex) {
            System.out.println("SQLExeption:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("ERROR:" + ex.getErrorCode());

        } 
//        catch (IOException ex) {
//            Logger.getLogger(LoginUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public static ProfesorDAO getInstance() throws IOException{
     if (instance == null) {
            instance = new ProfesorDAO();
        }
        return instance;
    }
    public Connection getProfesorDAO() {
        return connP;
    }
}
