/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kutay
 */
public class KullaniciEklePostreSQL implements IKullaniciEkle{
    private static IKullaniciEkle instance;
    private KullaniciEklePostreSQL(){
        
    }
    public static synchronized IKullaniciEkle getInstance(){
        if(instance==null)
            instance = new KullaniciEklePostreSQL();
        return instance;
    }
    
    @Override
    public void kullaniciEkle(Kullanici kullanici) {
        String adi=kullanici.getAdi();
        String soyadi=kullanici.getSoyadi();
        String mail=kullanici.getMail();
        String sifre=kullanici.getSifre();
        
        Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
        
        String sql= "Insert Into \"Kullanici\" (\"Adi\",\"Soyadi\",\"Mail\",\"Sifre\") VALUES(?,?,?,?)";
        if(!mailVarMi(mail)){
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, adi);
            preparedStatement.setString(2, soyadi);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, sifre);
            
            preparedStatement.executeUpdate();
            
            conn.close();
            System.out.println(adi+" isimli kullanici basariyla eklendi");
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciEklePostreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        else
            System.out.println(mail+" BU MAIL ADRESI KULLANILIYOR");
    }
    private boolean mailVarMi(String mail){ //private yani sadece burda kullanmam gereken ve baska sinifi kullanan bir method.
        IKullanicilariGetir kullanicilariGetir=KullanicilariGetirPostgreSQL.getInstance();
        List<Kullanici> kullanicilar=new ArrayList<Kullanici>();
        kullanicilar=kullanicilariGetir.kullanicilariGetir();
        for(Kullanici kullanici:kullanicilar){
            if(kullanici.getMail().equals(mail))
                return true;
        }
        return false;
    }
    
}
