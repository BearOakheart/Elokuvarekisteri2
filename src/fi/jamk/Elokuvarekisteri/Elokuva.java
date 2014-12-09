/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.io.Serializable;

/**
 *
 * @author Asmo
 */
public class Elokuva implements Serializable {
        private int id;
        private String nimi;
        private String ohjaaja;
        private String nayttelijat;
        private String lajityyppi;
        private String julkaisuvuosi;
        private String pituus;
        private String juoni;
        private String kuvaUrl;


    public Elokuva(int id,String nimi, String ohjaaja, String nayttelijat, String lajityyppi, String julkaisuvuosi, String pituus, String juoni, String kuvaUrl) {
        this.id = id;
        this.nimi = nimi;
        this.ohjaaja = ohjaaja;
        this.nayttelijat = nayttelijat;
        this.lajityyppi = lajityyppi;
        this.julkaisuvuosi = julkaisuvuosi;
        this.pituus = pituus;
        this.juoni = juoni;
        this.kuvaUrl = kuvaUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKuvaUrl() {
        return kuvaUrl;
    }

    public void setKuvaUrl(String kuvaUrl) {
        this.kuvaUrl = kuvaUrl;
    }
    
        
    public String getLajityyppi() {
        return lajityyppi;
    }

    public void setLajityyppi(String lajityyppi) {
        this.lajityyppi = lajityyppi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOhjaaja() {
        return ohjaaja;
    }

    public void setOhjaaja(String ohjaaja) {
        this.ohjaaja = ohjaaja;
    }

    public String getJulkaisuvuosi() {
        return julkaisuvuosi;
    }

    public void setJulkaisuvuosi(String julkaisuvuosi) {
        this.julkaisuvuosi = julkaisuvuosi;
    }

    public String getPituus() {
        return pituus;
    }

    public void setPituus(String pituus) {
        this.pituus = pituus;
    }
    public String getNayttelijat() {
        return nayttelijat;
    }

    public void setNayttelijat(String nayttelijat) {
        this.nayttelijat = nayttelijat;
    }

    public String getJuoni() {
        return juoni;
    }

    public void setJuoni(String juoni) {
        this.juoni = juoni;
    }
    @Override
    public String toString() {
        return "[" + nimi + ", " + ohjaaja + ", " + julkaisuvuosi + ", " + pituus + " min ," + lajityyppi + "]";
    }
}
