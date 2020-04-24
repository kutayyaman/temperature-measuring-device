/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

/**
 *
 * @author kutay
 */
public class Durum {
    String durumMesaji;
    String calisabilirDurumdaMi;
    String durumBKAK;

    public Durum(String durumMesaji, String calisabilirDurumdaMi, String durumBKAK) {
        this.durumMesaji = durumMesaji;
        this.calisabilirDurumdaMi = calisabilirDurumdaMi;
        this.durumBKAK = durumBKAK;
    }
    
    
    public String getDurumMesaji() {
        return durumMesaji;
    }

    public void setDurumMesaji(String durumMesaji) {
        this.durumMesaji = durumMesaji;
    }

    public String getCalisabilirDurumdaMi() {
        return calisabilirDurumdaMi;
    }

    public void setCalisabilirDurumdaMi(String calisabilirDurumdaMi) {
        this.calisabilirDurumdaMi = calisabilirDurumdaMi;
    }

    public String getDurumBKAK() {
        return durumBKAK;
    }

    public void setDurumBKAK(String durumBKAK) {
        this.durumBKAK = durumBKAK;
    }

   
    
    
    
}
