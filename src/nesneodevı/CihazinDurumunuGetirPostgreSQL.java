/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CihazinDurumunuGetirPostgreSQL implements ICihazinDurumunuGetir{
    private static ICihazinDurumunuGetir instance;
    private CihazinDurumunuGetirPostgreSQL(){
        
    }
    public static synchronized ICihazinDurumunuGetir getInstance(){
        if(instance==null)
            instance=new CihazinDurumunuGetirPostgreSQL();
        return instance;
    }
    @Override
    public Durum getir(AkilliCihaz akilliCihaz) {
        Durum durum=null;
        int durumID=akilliCihaz.getDurumID();
        Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
            Statement statement;
        try {
            statement = conn.createStatement();
            String sorgu="SELECT * FROM \"Durum\" WHERE \"DurumID\"='"+durumID+"'";
            ResultSet rs=statement.executeQuery(sorgu);
            conn.close();
            while(rs.next()){
                String durumMesaji=rs.getString("DurumMesaji");
                String calisabilirDurumdaMi=rs.getString("CalisabilirDurumdaMi");
                String durumBKAK=rs.getString("DurumBKAK");
                durum=new Durum(durumMesaji, calisabilirDurumdaMi, durumBKAK);
        }
        } catch (SQLException ex) {
            Logger.getLogger(KullanicilariGetirPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return durum;
    }
    
}
