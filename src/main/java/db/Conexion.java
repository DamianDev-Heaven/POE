package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private Connection con;
    public Connection oCon;
    
    
    public Conexion(String pUsuario, String pClave)
    {
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            this.oCon= DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/poe",
                    pUsuario,pClave);
        }
        catch(Exception ee)
        {}
    }
    
    
}
