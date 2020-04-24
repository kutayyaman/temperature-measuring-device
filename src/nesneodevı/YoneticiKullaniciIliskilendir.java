/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.util.List;

/**
 *
 * @author kutay
 */
public class YoneticiKullaniciIliskilendir {
    public void iliskilendir(Yonetici yonetici){
        List<Kullanici> kullanicilar=KullanicilariGetirPostgreSQL.getInstance().kullanicilariGetir();
        for(Kullanici kullanici:kullanicilar){
            yonetici.attach(kullanici);
        }
    }
}
