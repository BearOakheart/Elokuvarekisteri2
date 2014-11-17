/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Asmo
 */
public class ElokuvaUI extends JFrame {
    private Elokuvalista elokuvalista;
    private Elokuvamalli elokuvamalli;
    private Henkilolista henkilolista;
    private Henkilomalli henkilomalli;
    
    private JTable elokuvatable;
    private JTable henkilotable;
    
    private JScrollPane jScrollPane;
    private JScrollPane jScrollPane2;
    
    public ElokuvaUI() {
        setTitle("What da fuq - Elokuvarekisteri");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jScrollPane = new javax.swing.JScrollPane();
        elokuvatable = new javax.swing.JTable();
        jScrollPane.setViewportView(elokuvatable);
        
        jScrollPane2 = new javax.swing.JScrollPane();
        henkilotable = new javax.swing.JTable();
        jScrollPane2.setViewportView(henkilotable);
        
        elokuvalista = new Elokuvalista();
        elokuvamalli = new Elokuvamalli(elokuvalista);
        elokuvatable.setModel(elokuvamalli);
        
        henkilolista = new Henkilolista();
        henkilomalli = new Henkilomalli(henkilolista);
        henkilotable.setModel(henkilomalli);
        
        JPanel paneeli = new JPanel();
        
        JButton lisaa = new JButton("Lisaa uusi elokuva (rivi)");
        JButton jarjesta = new JButton("Jarjestä valmistusvuoden mukaan");
        JButton poista = new JButton("Poista valittu elokuva");
        
        paneeli.add(lisaa);
        paneeli.add(poista);
        paneeli.add(jarjesta);
        
        JPanel henkilopaneeli = new JPanel();
        
        JButton lisaahenkilo = new JButton("Lisää uusi henkilö");
        JButton jarjestahenkilot = new JButton ("Järjestä syntymävuoden mukaan");
        JButton poistahenkilo = new JButton("Poista valittu henkilö");
        
        henkilopaneeli.add(lisaahenkilo);
        henkilopaneeli.add(jarjestahenkilot);
        henkilopaneeli.add(poistahenkilo);
        
        lisaahenkilo.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                henkilomalli.lisaa();
            }
        
        });
        jarjestahenkilot.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                henkilomalli.jarjesta();
            }
        
        });
        poistahenkilo.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                int valittuRivi = henkilotable.getSelectedRow();
                henkilomalli.poistaRivi(valittuRivi);
            }
        
        });
        
        // tapahtuman käsittelijät
        lisaa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                elokuvamalli.lisaa();
            
            }
        
        });
        
        jarjesta.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            elokuvamalli.jarjesta();
        }
        });
        
        poista.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                
            int valittuRivi = elokuvatable.getSelectedRow();
            elokuvamalli.poistaRivi(valittuRivi);
            }
        });
        
        // UI
        getContentPane().add(jScrollPane, BorderLayout.WEST);
        getContentPane().add(paneeli, BorderLayout.NORTH);
        pack();
        getContentPane().add(jScrollPane2, BorderLayout.EAST);
        getContentPane().add(henkilopaneeli, BorderLayout.SOUTH);
       pack();
    
    }
    
    public static void main (String args[])
    {
    // sovelluksen tuntuma
        try
        {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            System.out.println("Haluttua tuntumaa ei saada alustettua" +ex);
        }
        
        // sovelluksen UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElokuvaUI().setVisible(true);
            }
        
        });
     
    }
}
