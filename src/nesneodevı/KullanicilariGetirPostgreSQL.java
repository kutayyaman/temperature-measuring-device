/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kutay
 */
public class KullanicilariGetirPostgreSQL implements IKullanicilariGetir {
    private static IKullanicilariGetir instance;
    private KullanicilariGetirPostgreSQL(){
        
    }
    public static synchronized IKullanicilariGetir getInstance(){
        if(instance==null)
            instance = new KullanicilariGetirPostgreSQL();
        return instance;
    }
    
    @Override
    public List<Kullanici> kullanicilariGetir() {
            ArrayList<Kullanici> kullanicilar=new ArrayList<Kullanici>();
            Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
            Statement statement;
        try {
            statement = conn.createStatement();
            String sorgu="SELECT * FROM \"Kullanici\"";
            ResultSet rs=statement.executeQuery(sorgu);
            conn.close();
            while(rs.next()){
                int KullaniciID=rs.getInt("KullaniciID");
                String Adi=rs.getString("Adi");
                String Soyadi=rs.getString("Soyadi");
                String Mail=rs.getString("Mail");
                String Sifre=rs.getString("Sifre");
                
                Kullanici kullanici=new Kullanici(Adi,Soyadi,Mail,Sifre);
                kullanici.setKullaniciID(KullaniciID);
                kullanicilar.add(kullanici);
        }
        } catch (SQLException ex) {
            Logger.getLogger(KullanicilariGetirPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            return kullanicilar;
    }
    
}
