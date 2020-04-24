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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kutay
 */
public class AkilliCihazlariGetirPostgreSQL implements IAkilliCihazlariGetir {
    private static IAkilliCihazlariGetir instance;
    private AkilliCihazlariGetirPostgreSQL(){
        
    }
    public static synchronized IAkilliCihazlariGetir getInstance(){
        if(instance==null)
            instance = new AkilliCihazlariGetirPostgreSQL();
        return instance;
    }
    
    @Override
    public List<AkilliCihaz> akilliCihazlariGetir() {
        ArrayList<AkilliCihaz> akilliCihazlar=new ArrayList<AkilliCihaz>();
            Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
            Statement statement;
        try {
            statement = conn.createStatement();
            String sorgu="SELECT * FROM \"AkilliCihaz\"";
            ResultSet rs=statement.executeQuery(sorgu);
            conn.close();
            while(rs.next()){
                int akilliCihazID=rs.getInt("AkilliCihazID");
                String markasi=rs.getString("Markasi");
                String modeli=rs.getString("Modeli");
                String yazilimVersiyonu=rs.getString("YazilimVersiyonu");
                String sicaklik=rs.getString("Sicaklik");
                int durumID=rs.getInt("DurumID");
                
                AkilliCihaz akilliCihaz=new AkilliCihaz(markasi, modeli, yazilimVersiyonu, sicaklik, durumID);
                akilliCihaz.setAkilliCihazID(akilliCihazID);
                akilliCihazlar.add(akilliCihaz);
        }
        } catch (SQLException ex) {
            Logger.getLogger(KullanicilariGetirPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            return akilliCihazlar;
    }
    
}
