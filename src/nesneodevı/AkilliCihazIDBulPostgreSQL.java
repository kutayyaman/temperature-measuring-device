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
public class AkilliCihazIDBulPostgreSQL implements IAkilliCihazIDBul{
    private static IAkilliCihazIDBul instance;
    private AkilliCihazIDBulPostgreSQL(){
        
    }
    public static synchronized IAkilliCihazIDBul getInstance(){
        if(instance==null)
            instance = new AkilliCihazIDBulPostgreSQL();
        return instance;
    }
    
    
    @Override
    public List<Integer> bul(int kullaniciID) {
        ArrayList<Integer> cihazIDleri=new ArrayList<Integer>();
        Connection conn=VeritabaniBaglantisiPostgreSQL.getInstance().baglan();
            Statement statement;
        try {
            statement = conn.createStatement();
            String sorgu="SELECT \"AkilliCihazID\" FROM \"CihazKullanici\" WHERE \"KullaniciID\"='"+kullaniciID+"'";
            ResultSet rs=statement.executeQuery(sorgu);
            conn.close();
            while(rs.next()){
                int akilliCihazID=rs.getInt("AkilliCihazID");
                cihazIDleri.add(kullaniciID);
        }
        } catch (SQLException ex) {
            Logger.getLogger(KullanicilariGetirPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cihazIDleri;
    }
    
}
