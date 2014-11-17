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
    
    private JTable elokuvatable;
    private JScrollPane jScrollPane;
    
    public ElokuvaUI() {
        setTitle("What da fuq - Elokuvarekisteri");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jScrollPane = new javax.swing.JScrollPane();
        elokuvatable = new javax.swing.JTable();
        jScrollPane.setViewportView(elokuvatable);
        
        elokuvalista = new Elokuvalista();
        elokuvamalli = new Elokuvamalli(elokuvalista);
        elokuvatable.setModel(elokuvamalli);
                
        JPanel paneeli = new JPanel();
        
        JButton lisaa = new JButton("Lisaa uusi elokuva (rivi)");
        JButton jarjesta = new JButton("Jarjesta valmistusvuoden mukaan");
        JButton poista = new JButton("Poista valittu");
        
        paneeli.add(lisaa);
        paneeli.add(poista);
        paneeli.add(jarjesta);
        
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
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        getContentPane().add(paneeli, BorderLayout.SOUTH);
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
