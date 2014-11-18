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
public class Henkilo implements Serializable {
    private int id;
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;
    private String maa;
    private String rooli;
    
    public Henkilo(int id, String etunimi, String sukunimi, int syntymavuosi, String maa, String rooli)
    {
        this.id = id;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
        this.maa = maa;
        this.rooli = rooli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getSyntymavuosi() {
        return syntymavuosi;
    }

    public void setSyntymavuosi(int syntymavuosi) {
        this.syntymavuosi = syntymavuosi;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public String getRooli() {
        return rooli;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }
    
    @Override
    public String toString() {
        return "[" +id+ ", "+ etunimi + ", " + sukunimi + ", " + syntymavuosi + ", " + maa + "," + rooli + "]";
    }
}
