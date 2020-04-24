
package nesneodevı;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kutay
 */
public class SicakligiGuncellePostgreSQL implements ISicakligiGuncelle {
    private static ISicakligiGuncelle instance;
    
    private SicakligiGuncellePostgreSQL(){
        
    }
    public static synchronized ISicakligiGuncelle getInstance(){
        if(instance==null)
            instance = new SicakligiGuncellePostgreSQL();
        return instance;
    } 
    @Override
    public void guncelle(int akilliCihazID,int sicaklik) {
        Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
            Statement statement;
        try {
            statement = conn.createStatement();
            String sorgu="UPDATE \"AkilliCihaz\" SET \"Sicaklik\"="+sicaklik+" WHERE \"AkilliCihazID\"="+akilliCihazID+";";
            statement.executeUpdate(sorgu);
            conn.close();
            System.out.println("Olculen Yeni Sicaklik Degeri Veritabaninda Guncellendi");
        } catch (SQLException ex) {
            Logger.getLogger(KullanicilariGetirPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
