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
        private int valmistusvuosi;
        private int pituus;
        
    public Elokuva(String nimi, String ohjaaja, int valmistusvuosi, int pituus)
    {
        this.nimi = nimi;
        this.ohjaaja = ohjaaja;
        this.valmistusvuosi = valmistusvuosi;
        this.pituus = pituus;
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

    public int getValmistusvuosi() {
        return valmistusvuosi;
    }

    public void setValmistusvuosi(int valmistusvuosi) {
        this.valmistusvuosi = valmistusvuosi;
    }

    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        this.pituus = pituus;
    }
  
     @Override
    public String toString() {
        return "[" + nimi + " " + ohjaaja + ", " + valmistusvuosi + ", " + pituus + " min.]";
    }
}
