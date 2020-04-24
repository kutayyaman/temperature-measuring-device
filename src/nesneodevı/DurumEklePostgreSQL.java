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
public class DurumEklePostgreSQL implements IDurumEkle {
    private static IDurumEkle instance;
    private DurumEklePostgreSQL(){
        
    }
    public static synchronized IDurumEkle getInstance(){
        if(instance==null)
            instance=new DurumEklePostgreSQL();
        return instance;
    }
    
    @Override
    public void durumEkle(Durum durum) {
        String calisabilirDurumdaMi=durum.getCalisabilirDurumdaMi();
        String durumBKAK=durum.getDurumBKAK();
        String durumMesaji=durum.getDurumMesaji();
        
        Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
        
        String sql= "Insert Into \"Durum\" (\"DurumMesaji\",\"CalisabilirDurumdaMi\",\"DurumBKAK\") VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, durumMesaji);
            preparedStatement.setString(2, calisabilirDurumdaMi);
            preparedStatement.setString(3, durumBKAK);
            
            preparedStatement.executeUpdate();
            
            conn.close();
            System.out.println("durum basariyla eklendi");
            return;
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciEklePostreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Durum Eklenemedi.");
    }
    
}
