/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kutay
 */
public class AkilliCihazEklePostgreSQL implements IAkilliCihazEkle {
    private static IAkilliCihazEkle instance;
    private AkilliCihazEklePostgreSQL(){
        
    }
    public static synchronized IAkilliCihazEkle getInstance(){
        if(instance==null)
            instance=new AkilliCihazEklePostgreSQL();
        return instance;
    }
    @Override
    public void akilliCihazEkle(AkilliCihaz akilliCihaz) {
        String markasi=akilliCihaz.getMarkasi();
        String modeli=akilliCihaz.getModeli();
        String yazilimVersiyonu=akilliCihaz.getYazilimVersiyonu();
        String sicaklik=akilliCihaz.sicaklik;
        int durumID=akilliCihaz.getDurumID();
        
        Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
        
        String sql= "Insert Into \"AkilliCihaz\" (\"Markasi\",\"Modeli\",\"YazilimVersiyonu\",\"Sicaklik\",\"DurumID\") VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, markasi);
            preparedStatement.setString(2, modeli);
            preparedStatement.setString(3, yazilimVersiyonu);
            preparedStatement.setString(4, sicaklik);
            preparedStatement.setInt(5, durumID);
            
            preparedStatement.executeUpdate();
            
            conn.close();
            System.out.println(modeli+" modelli akilli cihaz basariyla eklendi");
            return;
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciEklePostreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Akilli Cihaz Eklenemedi.");
    }
    
}
