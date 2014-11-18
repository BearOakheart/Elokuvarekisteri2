/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Asmo
 */
public class ElokuvarekisteriUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    private Elokuvalista elokuvalista;
    private Elokuvamalli elokuvamalli;
    private Henkilolista henkilolista;
    private Henkilomalli henkilomalli;
    
    private JTable elokuvatable;
    private JTable henkilotable;
    
    private JScrollPane jScrollPane;
    private JScrollPane jScrollPane2;
    
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
        
        // tehdään JTabbedPane
        tabbedPane = new JTabbedPane();
        // lisätään panel1 JTabbedPaneen
        tabbedPane.addTab("Elokuvat",panel1);
        // lisätään panel2 JTabbedPaneen       
        tabbedPane.addTab("Henkilöt",panel2);
        // lisätään panel3 JTabbedPaneen       
        tabbedPane.addTab("Teattereissa",panel3);
        
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
    }
    
    public final void teePanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JLabel label1 = new JLabel("Käyttäjä:");
        JTextField field = new JTextField();
        field.setColumns(18);
        JLabel label2 = new JLabel("Salasana:");
        JPasswordField fieldPass = new JPasswordField();
        fieldPass.setColumns(18);
        JPanel sisalto = new JPanel();
        sisalto.setLayout(new FlowLayout(FlowLayout.LEFT));
        sisalto.add(label1);
        sisalto.add(field);
        sisalto.add(label2);
        sisalto.add(fieldPass);  
        JLabel teksti = new JLabel("JLabel - JTextField - JPasswordField");
        sisalto.add(teksti);
        panel2.add(sisalto,BorderLayout.CENTER);
    }
    
    public final void teePanel3() {
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JPanel sisalto = new JPanel();
        sisalto.setLayout(new FlowLayout(FlowLayout.LEFT));     
        JLabel otsikko = new JLabel("Valitse suosikkikielesi:");
        
        sisalto.add(otsikko);
          
        panel3.add(sisalto, BorderLayout.NORTH);
        
        JScrollPane js = new JScrollPane();
        
        panel3.add(js, BorderLayout.CENTER);
        
    }
    
    public static void main( String args[] ) {
        new ElokuvarekisteriUI().setVisible(true);
    }
    
}
