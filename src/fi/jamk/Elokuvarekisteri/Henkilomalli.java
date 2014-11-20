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
public class Henkilomalli extends AbstractTableModel {
    private final String[] sarakeNimet = new String[]{"Id", "Etunimi", "Sukunimi", "Syntymävuosi", "Maa", "Rooli"};
    private Henkilolista henkilolista;
    private Class<?>[] tyypit = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, String.class};
    
    public Henkilomalli() {
        this.henkilolista = new Henkilolista();
    }
    
    public Henkilomalli(Henkilolista henkilolista){
        this.henkilolista = henkilolista;
    
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
        ArrayList<Henkilo> henkilot = this.henkilolista.palauta();
        int koko = henkilot.size();
        Henkilo henkilo = henkilot.get(koko-1);
        return henkilo.getId();       
    }
    
    public Henkilo getHenkiloAt(int id){
        ArrayList<Henkilo> henkilot = this.henkilolista.palauta();
        Henkilo henkilo = henkilot.get(id);
        return henkilo;  

    }
    @Override
    public Object getValueAt(int rivi, int sarake) {
        if (rivi < 0 || rivi >= henkilolista.palauta().size()) return null;
        Henkilo henkilo = henkilolista.palauta().get(rivi);
        switch (sarake) {
            case 0:  return henkilo.getId();
            case 1:  return henkilo.getEtunimi();
            case 2:  return henkilo.getSukunimi();
            case 3:  return henkilo.getSyntymavuosi();
            case 4:  return henkilo.getMaa();
            case 5:  return henkilo.getRooli();
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object uusi, int rivi, int sarake) {
        if (sarake >= 0 && sarake < sarakeNimet.length)
        {
            henkilolista.paivita(uusi, rivi, sarake);
            // ilmoittaa datan muutoksesta JTable-komponentille
            fireTableCellUpdated(rivi, sarake);
        
        }
    
    }
    
    @Override
    public int getRowCount() {
        return henkilolista.palauta().size();
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
    
    public void lisaa(Henkilo h) {
        henkilolista.lisaaUusi(h);
        this.fireTableDataChanged();
    }
    
    public void jarjesta() {
        henkilolista.jarjesta();
        this.fireTableDataChanged();
    }
        
    public void poistaRivi(int rivi) {
        if (rivi >= 0) {
            henkilolista.poista(rivi);
            this.fireTableDataChanged();
        }
    }
}
