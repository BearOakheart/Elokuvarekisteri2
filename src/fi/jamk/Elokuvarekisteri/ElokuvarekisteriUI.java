/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
    
    private Image image;
    
    private JTable elokuvatable;
    private JTable henkilotable;
    
    private JScrollPane jScrollPane;
    private JScrollPane jScrollPane2;
    
    private ArrayList<String> elokuvantiedot = new ArrayList<String>();
    
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
        
        tabbedPane.addTab("Hae elokuvaa OMDB:stä",panel4);
        
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
                LisaaElokuvaJDialog LEDialog = new LisaaElokuvaJDialog(ElokuvarekisteriUI.this, rootPaneCheckingEnabled);
                LEDialog.setVisible(true);
            
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
               
                
                LisaaHenkiloJDialog LHdialog = new LisaaHenkiloJDialog(ElokuvarekisteriUI.this, rootPaneCheckingEnabled);
                LHdialog.setVisible(true); 
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
        JLabel otsikko = new JLabel("");
        
        String[] kaupungit = {"Pääkaupunkiseutu",
            "Espoo","Espoo: Omena",
            "Espoo: Sello",
            "Helsinki","Helsinki: Kinopalatsi",
            "Helsinki: Maxim",
            "Helsinki: Tennispalatsi",
            "Jyväskylä","Kuopio",
            "Lahti","Oulu",
            "Pori","Tampere",
            "Tampere: Cine Atlas","Tampere: Plevna",
            "Turku","Vantaa"};
      
        JComboBox jcb = new JComboBox(kaupungit);

        JButton testi = new JButton("testi");
        JTextArea textArea = new JTextArea("hihi");
        
        sisalto.add(jcb);
        sisalto.add(testi);
        sisalto.add(otsikko);
        
        
        
          
        panel3.add(sisalto, BorderLayout.NORTH);
        
        JScrollPane js = new JScrollPane();
        
        sisalto.add(textArea);
        
        panel3.add(js, BorderLayout.CENTER);
        
        
        
        testi.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                
                String valittu = jcb.getSelectedItem().toString();
                System.out.println(valittu);
                String kaupunki = "";
                
                switch(valittu) {
                    case "Pääkaupunkiseutu": kaupunki = "1014";
                        break;
                    case "Espoo": kaupunki = "1012";
                        break;            
                    case "Espoo: Omena": kaupunki = "1039";
                        break;                                
                    case "Espoo: Sello": kaupunki = "1038";
                        break;                                 
                    case "Helsinki": kaupunki = "1002";
                        break;                                 
                    case "Helsinki: Kinopalatsi": kaupunki = "1031";
                        break;                                 
                    case "Helsinki: Maxim": kaupunki = "1032";
                        break;                                 
                    case "Helsinki: Tennispalatsi": kaupunki = "1033";
                        break;                                 
                    case "Jyväskylä": kaupunki = "1015";
                        break;                                 
                    case "Kuopio": kaupunki = "1016";
                        break;                                     
                    case "Lahti": kaupunki = "1017";
                        break;                        
                    case "Oulu": kaupunki = "1018";
                        break;                        
                    case "Pori": kaupunki = "1019";
                        break;             
                    case "Tampere": kaupunki = "1021";
                        break;                        
                    case "Tampere: Cine Atlas": kaupunki = "1034";
                        break;                            
                    case "Tampere: Plevna": kaupunki = "1035";
                        break;                        
                    case "Turku": kaupunki = "1022";
                        break;
                    case "Vantaa": kaupunki = "1013";
                        break;      
                }
                
                
                XmlReader xmlreader = new XmlReader();
                
                xmlreader.setKaupunki(kaupunki);
                
                xmlreader.readFinnKinoXML();  
                
                textArea.append(xmlreader.getTieto());
            }
        
        });
        
        
        
    }
    
    public final void teePanel4() {
        panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        JPanel header = new JPanel();
        JPanel sisaltoVasen = new JPanel();
        JPanel sisaltoOikea = new JPanel();
        
        // box layout
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        sisaltoVasen.setLayout(new BoxLayout(sisaltoVasen, BoxLayout.Y_AXIS));
        sisaltoOikea.setLayout(new BoxLayout(sisaltoOikea, BoxLayout.Y_AXIS));
        
        
        JButton haeNappi = new JButton("Hae OMDB:stä");
        JButton lisaaNappi = new JButton("Lisää rekisteriin");
        
        JTextField hakukentta = new JTextField();
        
        JLabel nimikentta = new JLabel();
        JLabel ohjaajakentta = new JLabel();
        JLabel nayttelijatkentta = new JLabel();
        JLabel lajityyppikentta = new JLabel();
        JLabel vuosikentta = new JLabel();
        JLabel pituuskentta = new JLabel();
        JLabel juonikentta = new JLabel();
        
        JLabel nimi = new JLabel("Elokuvan nimi:");
        JLabel ohjaaja = new JLabel("Ohjaaja:");
        JLabel nayttelijat = new JLabel("Näyttelijät:");
        JLabel lajityyppi = new JLabel("Lajityyppi:");
        JLabel vuosi = new JLabel("Vuosi:");
        JLabel pituus = new JLabel("Pituus:");
        JLabel juoni = new JLabel("Juoni:");
       
        
       
       
        header.add(hakukentta);
        header.add(haeNappi);
        header.add(Box.createHorizontalStrut(2));
        
        // vasemman paneelin lisäykset
        sisaltoVasen.add(nimi);
        sisaltoVasen.add(ohjaaja);
        sisaltoVasen.add(nayttelijat);
        sisaltoVasen.add(lajityyppi);
        sisaltoVasen.add(vuosi);
        sisaltoVasen.add(pituus);
        sisaltoVasen.add(juoni);
        
        sisaltoVasen.add(lisaaNappi);
        //sisaltoVasen.add(Box.createVerticalStrut(10));
        
        // oiken paneelin lisäykset
        sisaltoOikea.add(nimikentta);
        sisaltoOikea.add(ohjaajakentta);
        sisaltoOikea.add(nayttelijatkentta);
        sisaltoOikea.add(lajityyppikentta);
        sisaltoOikea.add(vuosikentta);
        sisaltoOikea.add(pituuskentta);
        sisaltoOikea.add(juonikentta);
       
        //sisaltoOikea.add(Box.createVerticalStrut(10));
        
        panel4.add(header, BorderLayout.NORTH);
        panel4.add(sisaltoVasen, BorderLayout.WEST);
        panel4.add(sisaltoOikea, BorderLayout.CENTER);
        
     
        
        
        haeNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //henkilomalli.lisaa();              
                XmlReader reader = new XmlReader();

                try {
                    String movieName = hakukentta.getText();

                    movieName = movieName.replaceAll("\\s+", "+");
                    
                    elokuvantiedot = reader.getMovieXml(movieName);

                    nimikentta.setText(elokuvantiedot.get(0));
                    ohjaajakentta.setText(elokuvantiedot.get(1));
                    nayttelijatkentta.setText(elokuvantiedot.get(2));
                    lajityyppikentta.setText(elokuvantiedot.get(3));
                    vuosikentta.setText(elokuvantiedot.get(4));
                    pituuskentta.setText(elokuvantiedot.get(5));
                    juonikentta.setText(elokuvantiedot.get(6));
                    
                    
                    
                    image = null;
                    try {

                        URL url = new URL(elokuvantiedot.get(7));
                        image = ImageIO.read(url);
                        System.err.println("kuva ladattu");
                    } catch (IOException ex) {
                        Logger.getLogger(ElokuvarekisteriUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Kaytan kuvaa");
                    JLabel kuva = new JLabel(new ImageIcon(image));
                    sisaltoOikea.add(kuva);
                } catch (TransformerException ex) {
                    Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        
        lisaaNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Elokuva elokuva = new Elokuva(elokuvantiedot.get(0),
                                                elokuvantiedot.get(1), 
                                                elokuvantiedot.get(2), 
                                                elokuvantiedot.get(3), 
                                                elokuvantiedot.get(4), 
                                                elokuvantiedot.get(5),
                                                elokuvantiedot.get(6));
                elokuvamalli.lisaa(elokuva);
            }

        });
    }
    public static void main( String args[] ) {
        new ElokuvarekisteriUI().setVisible(true);
    }
    
}
