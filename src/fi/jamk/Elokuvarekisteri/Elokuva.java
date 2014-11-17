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
        private String nimi;
        private String ohjaaja;
        private int julkaisuvuosi;
        private int pituus;
        private String lajityyppi;
        
    public Elokuva(String nimi, String ohjaaja, int julkaisuvuosi, int pituus, String lajityyppi)
    {
        this.nimi = nimi;
        this.ohjaaja = ohjaaja;
        this.julkaisuvuosi = julkaisuvuosi;
        this.pituus = pituus;
        this.lajityyppi = lajityyppi;
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

    public int getJulkaisuvuosi() {
        return julkaisuvuosi;
    }

    public void setJulkaisuvuosi(int julkaisuvuosi) {
        this.julkaisuvuosi = julkaisuvuosi;
    }

    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        this.pituus = pituus;
    }
  
    @Override
    public String toString() {
        return "[" + nimi + " " + ohjaaja + ", " + julkaisuvuosi + ", " + pituus + " min," + lajityyppi + "]";
    }
}
