/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.util.Random;

/**
 *
 * @author kutay
 */
public class Algilayici implements IAlgilayici {
    static Random r;
    private static IAlgilayici instance;
    ISubject yonetici;
    private Algilayici(){
        yonetici=null;
    }
    public static synchronized IAlgilayici getInstance(){
        if(instance==null)
            instance=new Algilayici();
        return instance;
    }
    @Override
    public int sicaklikOku() {
         r=new Random();
         int sicaklik=-10 + r.nextInt(40+10);
         if(yonetici!=null)
         yonetici.notify("suanda olculen sicaklik:"+sicaklik);
         return sicaklik; //baslangic+rnd.nextInt(bitis-baslangic);
    }

    public void setYonetici(ISubject yonetici) {
        this.yonetici = yonetici;
    }
    
    
}
