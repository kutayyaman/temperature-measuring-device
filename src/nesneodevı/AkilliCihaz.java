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
public class AkilliCihaz {
    int akilliCihazID;

    public int getAkilliCihazID() {
        return akilliCihazID;
    }

    public void setAkilliCihazID(int akilliCihazID) {
        this.akilliCihazID = akilliCihazID;
    }
    String markasi;
    String modeli;
    String yazilimVersiyonu;
    String sicaklik;
    int durumID;

    public AkilliCihaz(String markasi, String modeli, String yazilimVersiyonu, String sicaklik, int durumID) {
        this.markasi = markasi;
        this.modeli = modeli;
        this.yazilimVersiyonu = yazilimVersiyonu;
        this.sicaklik = sicaklik;
        this.durumID = durumID;
    }

    public String getMarkasi() {
        return markasi;
    }

    public void setMarkasi(String markasi) {
        this.markasi = markasi;
    }

    public String getModeli() {
        return modeli;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public String getYazilimVersiyonu() {
        return yazilimVersiyonu;
    }

    public void setYazilimVersiyonu(String yazilimVersiyonu) {
        this.yazilimVersiyonu = yazilimVersiyonu;
    }

    public String getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(String sicaklik) {
        this.sicaklik = sicaklik;
    }

    public int getDurumID() {
        return durumID;
    }

    public void setDurumID(int durumID) {
        this.durumID = durumID;
    }
    
}
