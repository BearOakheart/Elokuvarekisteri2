/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asmo
 */
class Elokuvamalli extends AbstractTableModel {
    private final String[] sarakeNimet = new String[]{"Nimi", "Ohjaaja", "Valmistusvuosi (vm)", "Pituus (min)"};
    private Elokuvalista elokuvalista;
    private Class<?>[] tyypit = new Class[]{String.class, String.class, Integer.class, Integer.class};
    
    public Elokuvamalli() {
        this.elokuvalista = null;
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
    
    @Override
    public Object getValueAt(int rivi, int sarake) {
        if (rivi < 0 || rivi >= elokuvalista.palauta().size()) return null;
        Elokuva elokuva = elokuvalista.palauta().get(rivi);
        switch (sarake) {
            case 0:  return elokuva.getNimi();
            case 1:  return elokuva.getOhjaaja();
            case 2:  return elokuva.getValmistusvuosi();
            case 3:  return elokuva.getPituus();
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
    
    public void lisaa() {
        elokuvalista.lisaaUusi();
        this.fireTableDataChanged();
    }
    
    public void jarjesta() {
        elokuvalista.jarjesta();
        this.fireTableDataChanged();
    }
        
    public void poistaRivi(int rivi) {
        if (rivi >= 0) {
            elokuvalista.poista(rivi);
            this.fireTableDataChanged();
        }
    }
}
