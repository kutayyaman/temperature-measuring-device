
package nesneodevı;

import java.util.ArrayList;

/**
 *
 * @author kutay
 */
public class KullaniciDogrulaPostgreSQL implements IKullaniciDogrula{
    private static IKullaniciDogrula instance;
    private KullaniciDogrulaPostgreSQL(){
        
    }
    public static synchronized IKullaniciDogrula getInstance(){
        if(instance==null)
            instance=new KullaniciDogrulaPostgreSQL();
        return instance;
    }
    @Override
    public Kullanici dogrula(String mail,String sifre) {
        ArrayList<Kullanici> kullanicilar=(ArrayList<Kullanici>) KullanicilariGetirPostgreSQL.getInstance().kullanicilariGetir();
        for(Kullanici kullanici:kullanicilar){
            if(kullanici.getMail().equals(mail)&&kullanici.getSifre().equals(sifre)){
                return kullanici;
            }
                
        }
        return null;
        
    }
    
}
