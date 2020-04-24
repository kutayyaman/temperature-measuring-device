
package nesneodevı;

/**
 *
 * @author kutay
 */
public class Kullanici implements IObserver{
    private int kullaniciID;
    
  
    private String adi;
    private String soyadi;
    private String mail;
    private String sifre;

    @Override
    public void update(String m) {
        System.out.println(getAdi()+" isimli kullaniciya gelen duyuru:"+m);
    }
    
    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }
    
    public Kullanici(String adi, String soyadi, String mail, String sifre) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.mail = mail;
        this.sifre = sifre;
    }
    
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    
    
}
