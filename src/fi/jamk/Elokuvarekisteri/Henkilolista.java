/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Asmo
 */
class Henkilolista implements Serializable {
    private ArrayList<Henkilo> henkilot;
    private final String henkilonTiedot = "henkilolista.data";
    
    //konstruktori
    public Henkilolista() {
        this.henkilot = new ArrayList<>();
        alustaLista();
    }
    
    // luetaan tiedostosta tai luodaan oletus henkilöt
    private void alustaLista() {
    File hlo = new File(henkilonTiedot);
    
    if (!hlo.exists()) {
        henkilot.add(new Henkilo(01, "Jaakko", "Mäkelä", 1959, "Suomi", "Ohjaaja"));
        tallenna();
    }
    else {
        lue();
    }
        tulosta();
    }
    
    // tulostetaan henkilot output-ikkunaan
    private void tulosta() {
        for (Henkilo h : henkilot) {
        System.out.println(h);
        
        }
    }
    
    // Elokuvien lukeminen tiedostosta
    public void lue() {
        
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(new File(henkilonTiedot)));
            henkilot = (ArrayList<Henkilo>) input.readObject();
            
        } 
        catch (IOException ex)
        {
                System.out.println("Virhe tiedostosta luettaessa " + ex);
                
        }
        catch (ClassNotFoundException e) 
        {
                
        }
        finally 
        {
                try
                { 
                    if (input != null) input.close();
                }
                catch (IOException ex)
                {
                System.out.println("Virhe tiedoston sulkemisessa : " + ex);
                }
        }
        // debuggausta konsolille
        System.out.println("Henkilolista luettu uudelleen tiedostosta");
        tulosta();
    
    }
    // henkiloiden tallennus tiedostoon.
    public void tallenna() {
    
        ObjectOutputStream output = null;
        try
        {
            output = new ObjectOutputStream(new FileOutputStream(new File(henkilonTiedot)));
            output.writeObject(henkilot);
            
        }
        catch (IOException ex)
        {
            System.out.println("Virhe tiedostoon kirjoittamisessa " +ex);
        }
        finally 
        {
            try
            {
                if (output != null) output.close();
            }
            catch (IOException ex)
            {
                System.out.println("Virhe tiedostoa sulkiessa" +ex);
            }
        }
                
            
    }
    // palauttaa henkilölistan
    public ArrayList<Henkilo> palauta() {
        return henkilot;
    }
    // lisää uuden henkilön
    public void lisaaUusi() {
        henkilot.add(new Henkilo(01, "Etunimi", "Sukunimi", 0, "Maa", "Rooli"));
        tallenna();
    
    }
    // poistaa henkilön riviltä
    public void poista (int rivi) {
        henkilot.remove(rivi);
        tallenna();
    
    }
    // elokuvien jarjestaminen
    public void jarjesta() {
        Collections.sort(henkilot, new JarjestaHenkilot());
        System.out.println("Henkilot järjestetty syntymävuoden mukaan");
        tallenna();
    }
    
 
    
    public void paivita(Object uusi, int rivi, int sarake) {
        Henkilo henkilo = henkilot.get(rivi);
        if (sarake == 0) henkilo.setId(((Integer) uusi).intValue());
        else if (sarake == 1) henkilo.setEtunimi((String) uusi);
        else if (sarake == 2) henkilo.setSukunimi((String) uusi);
        else if (sarake == 3) henkilo.setSyntymavuosi(((Integer) uusi).intValue());
        else if (sarake == 4) henkilo.setMaa((String) uusi);
        else if (sarake == 5) henkilo.setRooli((String) uusi);
        henkilot.remove(rivi);
        henkilot.add(rivi, henkilo);
        tallenna();
    }
    
     class JarjestaHenkilot implements Comparator<Henkilo>
    {
         @Override
         public int compare (Henkilo h1, Henkilo h2)
         {
             if (h1.getSyntymavuosi() > h2.getSyntymavuosi()) return -1;
             if (h2.getSyntymavuosi() < h1.getSyntymavuosi()) return 1;
             return 0;
         }
    }
}