
package nesneodevı;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author kutay
 */
public class VeritabaniBaglantisiPostgreSQL implements IVeritabaniBaglantisi {
    
    private static IVeritabaniBaglantisi instance;
    
    private VeritabaniBaglantisiPostgreSQL(){
        
    }
    public static synchronized IVeritabaniBaglantisi getInstance(){
        if(instance==null)
            instance = new VeritabaniBaglantisiPostgreSQL();
        return instance;
    } 
    @Override
    public Connection baglan() {
        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NesneProje",
                    "postgres", "admin");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
