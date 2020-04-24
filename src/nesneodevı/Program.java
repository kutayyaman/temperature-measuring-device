/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kutay
 */
public class Program {
    public void baslat(){
        boolean devamMi=true;
        String mail;
        String sifre;
        Scanner scanner=new Scanner(System.in);
        while(devamMi){
            System.out.println("Mail Adresinizi Giriniz:");
            mail=scanner.nextLine();
            System.out.println("Sifrenizi Giriniz");
            sifre=scanner.nextLine();
            Kullanici kullanici=KullaniciDogrulaPostgreSQL.getInstance().dogrula(mail, sifre);
            if(kullanici==null)
            {
                System.out.println("YANLIS MAIL VEYA SIFRE GIRDINIZ!!!");
                continue;
            }
            Yonetici yonetici=new  Yonetici();
            YoneticiKullaniciIliskilendir yoneticiKullaniciIliskilendir=new YoneticiKullaniciIliskilendir();
            yoneticiKullaniciIliskilendir.iliskilendir(yonetici);//yoneticiye artik veritabanindaki tum kullanicilar abone
            Algilayici.getInstance().setYonetici(yonetici);
            kullaniciBilgileriYazdir(kullanici);
            cihazBilgileriYazdir(kullanici);
            break;
            
        }
    }
    private void kullaniciBilgileriYazdir(Kullanici kullanici){
        System.out.println(kullanici.getAdi()+" HOSGELDINIZ");
    }
    private void cihazBilgileriYazdir(Kullanici kullanici){
        List<AkilliCihaz> akilliCihazlar;
        AkilliCihaz akilliCihaz=null;
        List<Integer> cihazIDleri=AkilliCihazIDBulPostgreSQL.getInstance().bul(kullanici.getKullaniciID());
        int cihazID=cihazIDleri.get(0);
        akilliCihazlar=AkilliCihazlariGetirPostgreSQL.getInstance().akilliCihazlariGetir();
        for(AkilliCihaz a:akilliCihazlar){
            if(a.getAkilliCihazID()==cihazID)
                akilliCihaz=a;
        }
        if(akilliCihaz!=null){
            System.out.println("Akilli Cihazinizin Markasi:"+akilliCihaz.getMarkasi());
            System.out.println("Akilli Cihazinizin Modeli:"+akilliCihaz.getModeli());
            System.out.println("Akilli Cihazinizin Yazilim Versiyonu:"+akilliCihaz.getYazilimVersiyonu());
            System.out.println("Akilli Cihazinizin En Son Olctugu Sicaklik:"+akilliCihaz.getSicaklik());
            durumBilgileriYazdir(akilliCihaz);
            while(true){
                menu(akilliCihaz);
            }
        }
        else
            System.out.println("Cihaza Erisirken Problem Olustu");
    }
    private void durumBilgileriYazdir(AkilliCihaz akilliCihaz){
        Durum durum=CihazinDurumunuGetirPostgreSQL.getInstance().getir(akilliCihaz);
        System.out.println("Durum Mesaji:"+durum.getDurumMesaji());
        if(durum.getCalisabilirDurumdaMi().equals("E"))
            System.out.println("Cihaziniz Calisabilir Durumda");
        else
            System.err.println("Cihazinizin Calisamaz Durumda Teknik Servis Cagiriniz");
        System.out.println("Cihazinizin suanda bulundugu durum:"+durum.getDurumBKAK());
    }
    private void menu(AkilliCihaz akilliCihaz){
        System.out.println("1- Sicakligi Olc");
        System.out.println("2- Sogutucuyu Ac");
        System.out.println("3- Sogutucuyu Kapat");
        System.out.println("4- Cikis");
        int giris;
        Scanner scanner=new Scanner(System.in);
        giris=scanner.nextInt();
        switch(giris){
            case 1:
                int sicaklik=Algilayici.getInstance().sicaklikOku();
                SicakligiGuncellePostgreSQL.getInstance().guncelle(akilliCihaz.getAkilliCihazID(), sicaklik);
                System.out.println("Suanki Sicaklik Derecesi:"+sicaklik);
                break;
            case 2:
                System.out.println("Sogutucu Acildi");
                break;
            case 3:
                System.out.println("Sogutucu Kapatildi");
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("GECERSIZ BIR ISLEM GIRDINIZ");
                break;
        }
    }
}
