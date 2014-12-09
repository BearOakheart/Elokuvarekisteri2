/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asmo
 */
class Elokuvamalli extends AbstractTableModel {
    private final String[] sarakeNimet = new String[]{"Id","Nimi", "Ohjaaja", "Näyttelijät", "Lajityyppi", "Julkaisuvuosi", "Pituus (min)", "Juoni","Kuva URL"};
    private Elokuvalista elokuvalista;
    private Class<?>[] tyypit = new Class[]{Integer.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class};
    
    public Elokuvamalli() {
        this.elokuvalista = new Elokuvalista();
    }
    
    public Elokuvamalli(Elokuvalista elokuvalista){
        this.elokuvalista = elokuvalista;
    }
    @Override
    public String getColumnName(int sarakeIndeksi) {
        return sarakeNimet[sarakeIndeksi];
    }
    @Override
    public Class<?> getColumnClass(int sarakeIndeksi) {
        return tyypit[sarakeIndeksi];
    }
    
    public Integer getLastId() {
        ArrayList<Elokuva> elokuvat = this.elokuvalista.palauta();
        int koko = elokuvat.size();
        Elokuva elokuva = elokuvat.get(koko-1);
        return elokuva.getId();       
    }
    
    public Elokuva getElokuvaAt(int id){
        ArrayList<Elokuva> elokuvat = this.elokuvalista.palauta();
        Elokuva elokuva = elokuvat.get(id);
        return elokuva;  

    }
    
    @Override
    public Object getValueAt(int rivi, int sarake) {
        if (rivi < 0 || rivi >= elokuvalista.palauta().size()) return null;
        Elokuva elokuva = elokuvalista.palauta().get(rivi);
        switch (sarake) {
            case 0:  return elokuva.getId();
            case 1:  return elokuva.getNimi();
            case 2:  return elokuva.getOhjaaja();
            case 3:  return elokuva.getNayttelijat();
            case 4:  return elokuva.getLajityyppi();
            case 5:  return elokuva.getJulkaisuvuosi();
            case 6:  return elokuva.getPituus();
            case 7:  return elokuva.getJuoni();
            case 8:  return elokuva.getKuvaUrl();
            default: return null;
        }
    }
    
    /* Voidaan muuttaa taulukon käyttämän mallin arvoja toteuttamalla setValueAt() -metodi
     * jolle tulee parametrina päivitetty arvo, että sekä rivi että sarakenumero.
     */
    @Override
    public void setValueAt(Object uusi, int rivi, int sarake) {
        if (sarake >= 0 && sarake < sarakeNimet.length)
        {
            elokuvalista.paivita(uusi, rivi, sarake);
            // ilmoittaa datan muutoksesta JTable-komponentille
            fireTableCellUpdated(rivi, sarake);
        
        }
    
    }
    
     @Override
    public int getRowCount() {
        return elokuvalista.palauta().size();
    }
    
    @Override
    public int getColumnCount() {
        return sarakeNimet.length;
    }
    
    @Override
    public boolean isCellEditable(int rivi, int sarakeIndeksi) {
        switch (sarakeIndeksi) {
            // ota kommentti pois, jos haluat ettei esim. 1 sarake ole editoitavissa
            //case 0: return false; 
            default: return true;
        }
    }
    
    public void lisaaDummy() {
        elokuvalista.dummyLisaaUusi();
        this.fireTableDataChanged();
    }
    
    public void lisaa(Elokuva e){
        elokuvalista.lisaaUusi(e);
    }
    
    public void poistaRivi(int rivi) {
        if (rivi >= 0) {
            elokuvalista.poista(rivi);
            this.fireTableDataChanged();
        }
    }
}
