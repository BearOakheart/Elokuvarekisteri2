/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.transform.TransformerException;

/**
 *
 * @author Asmo
 */
public class ElokuvarekisteriUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    
    private Elokuvalista elokuvalista;
    private Elokuvamalli elokuvamalli;
    private Henkilolista henkilolista;
    private Henkilomalli henkilomalli;
    
    private JTable elokuvatable;
    private JTable henkilotable;
    
    private JScrollPane jScrollPane;
    private JScrollPane jScrollPane2;
    
    private javax.swing.JTextField HakuTextField;
    
    public ElokuvarekisteriUI() {
        super("Elokuvarekisteri");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // tehdään sovelluksen sisin paneeli, johon voidaan JTabbedPane lisätä
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        // tehdäänn panelit, jotka lisätään JTabbedPaneen
        teePanel1();
        teePanel2();
        teePanel3();
        teePanel4();
        
        // tehdään JTabbedPane
        tabbedPane = new JTabbedPane();
        // lisätään panel1 JTabbedPaneen
        tabbedPane.addTab("Elokuvat",panel1);
        // lisätään panel2 JTabbedPaneen       
        tabbedPane.addTab("Henkilöt",panel2);
        // lisätään panel3 JTabbedPaneen       
        tabbedPane.addTab("Teattereissa",panel3);
        
        tabbedPane.addTab("Hae Elokuvaa",panel4);
        
        // lisätään JTabbedPane sovellukseen 
        topPanel.add( tabbedPane, BorderLayout.CENTER );
        
        // koko
        //setSize(1000,800);
        pack();
    
    }
    
    public final void teePanel1() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        
        JButton lisaa = new JButton("Lisää elokuva");
        JButton jarjesta = new JButton("Järjestä julkaisuvuoden mukaan");
        JButton poista = new JButton("Poista valittu");
        
        JPanel paneeli = new JPanel();
        
        paneeli.add(lisaa);
        paneeli.add(jarjesta);
        paneeli.add(poista);
        
        jScrollPane = new javax.swing.JScrollPane();
        elokuvatable = new javax.swing.JTable();
        jScrollPane.setViewportView(elokuvatable);
        
        elokuvalista = new Elokuvalista();
        elokuvamalli = new Elokuvamalli(elokuvalista);
        elokuvatable.setModel(elokuvamalli);

        
        panel1.add(jScrollPane,BorderLayout.CENTER);
        panel1.add(paneeli,BorderLayout.SOUTH);
        pack();
        
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
    }
    
    public final void teePanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        
        JButton lisaahenkilo = new JButton("Lisää henkilö");
        JButton muokkaa = new JButton("Muokkaa");
        JButton poistahenkilo = new JButton("Poista valittu");
        
        JPanel paneeli2 = new JPanel();
        
        paneeli2.add(lisaahenkilo);
        paneeli2.add(muokkaa);
        paneeli2.add(poistahenkilo);
        
        jScrollPane2 = new javax.swing.JScrollPane();
        henkilotable = new javax.swing.JTable();
        jScrollPane2.setViewportView(henkilotable);
        
        henkilolista = new Henkilolista();
        henkilomalli = new Henkilomalli(henkilolista);
        henkilotable.setModel(henkilomalli);
        
        panel2.add(jScrollPane2,BorderLayout.CENTER);
        panel2.add(paneeli2,BorderLayout.SOUTH);
        pack();
        
        // tapahtuman käsitttelijät Henkilön lisäykselle, järjestämiselle ja poistamiselle, TODO muokkaus
        lisaahenkilo.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                //henkilomalli.lisaa();              
                LisaaHenkiloJFrame lhJFrame = new LisaaHenkiloJFrame();
                lhJFrame.setVisible(true);
            }
        
        });
        muokkaa.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                MuokkaaHenkiloJFrame muokkaa = new MuokkaaHenkiloJFrame(henkilotable.getSelectedRow());
                muokkaa.setVisible(true);
            }
        
        });
        poistahenkilo.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                int valittuRivi = henkilotable.getSelectedRow();
                henkilomalli.poistaRivi(valittuRivi);
            }
        
        });
    }
    
    public final void teePanel3() {
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JPanel sisalto = new JPanel();
        sisalto.setLayout(new FlowLayout(FlowLayout.LEFT));     
        JLabel otsikko = new JLabel("Mitä elokuvissa menee nyt, TODO");
        
        sisalto.add(otsikko);
          
        panel3.add(sisalto, BorderLayout.NORTH);
        
        JScrollPane js = new JScrollPane();
        
        panel3.add(js, BorderLayout.CENTER);
        
    }
    
    public final void teePanel4() {
        panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        JPanel header = new JPanel();
        JPanel sisalto = new JPanel();
        
        JButton haeNappi = new JButton("Hae OMDB:stä");
        HakuTextField = new JTextField();
        JTextField haku = new JTextField();
      
        haku.setPreferredSize(new Dimension(200,24));
        sisalto.setLayout(new FlowLayout(FlowLayout.LEFT));     
        JLabel otsikko = new JLabel("Hae elokuvaa open movie databasesta, TODO");
        
        header.add(otsikko, BorderLayout.NORTH);
        
        sisalto.add(haku);
        sisalto.add(haeNappi);
        
        panel4.add(header, BorderLayout.NORTH);
        panel4.add(sisalto, FlowLayout.LEFT);
        
        haeNappi.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                //henkilomalli.lisaa();              
            XmlReader reader = new XmlReader();
            
                try {
                    
                    //String movieName = "the Shawshank Redemption";
                    String movieName = haku.getText();
                    System.out.println(haku.getText());
                   
                    movieName = movieName.replaceAll("\\s+","+");
                    reader.getMovieXml(movieName);
                } catch (TransformerException ex) {
                    Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    });
    }
    public static void main( String args[] ) {
        new ElokuvarekisteriUI().setVisible(true);
    }
    
}
