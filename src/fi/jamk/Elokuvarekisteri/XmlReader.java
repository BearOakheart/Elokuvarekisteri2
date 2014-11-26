/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
//---------------------------------------
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//---------------------------------------
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//---
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**

/**
 *
 * @author Mikko2
 */
public class XmlReader {
    private ArrayList<String> elokuvantiedot = new ArrayList<String>();
    
    private String kaupunki;
    private String tieto;
    
    public void setKaupunki(String kaupunki){
    this.kaupunki = kaupunki;
    };
    
    public String getTieto(){
    return tieto;
    }
    
    @SuppressWarnings("UseSpecificCatch")
    public void readXMLfile() {

        try {

            File XmlFile = new File("temp_movie.xml");

            DocumentBuilderFactory dfb = DocumentBuilderFactory
                    .newInstance();

            DocumentBuilder dBuilder = dfb.newDocumentBuilder();

            Document doc = dBuilder.parse(XmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("movie");

            Element data = (Element) nodeList.item(0);
            System.out.println(data.getAttribute("title"));
            System.out.println(data.getAttribute("director"));
            System.out.println(data.getAttribute("actors"));
            System.out.println(data.getAttribute("genre"));
            System.out.println(data.getAttribute("year"));
            System.out.println(data.getAttribute("runtime"));
            System.out.println(data.getAttribute("plot"));
            System.out.println(data.getAttribute("poster"));
            
           elokuvantiedot.add(data.getAttribute("title"));
           elokuvantiedot.add(data.getAttribute("director"));
           elokuvantiedot.add(data.getAttribute("actors"));
           elokuvantiedot.add(data.getAttribute("genre"));
           elokuvantiedot.add(data.getAttribute("year"));
           elokuvantiedot.add(data.getAttribute("runtime"));
           elokuvantiedot.add(data.getAttribute("plot"));
           elokuvantiedot.add(data.getAttribute("poster"));
           
            
            
        } catch (Exception e) {
        }
        
    }
    
    public ArrayList<String> getMovieXml(String movieName) throws TransformerConfigurationException, TransformerException{
                URL url;
        try {
            url = new URL("http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=xml");
            URLConnection conn = url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            TransformerFactory factory3 = TransformerFactory.newInstance();
            Transformer xform = factory3.newTransformer();

            // that’s the default xform; use a stylesheet to get a real one
            xform.transform(new DOMSource(doc), new StreamResult(new File(System.getProperty("user.dir")+"/temp_movie.xml")));
            
           
            
            this.readXMLfile();

        } catch (MalformedURLException ex) {
            Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elokuvantiedot;
    }
         /*
        public class Tietoa implements Serializable{
        private String kaupunki;
            public Tietoa(String Kaupunki){
                    this.kaupunki = kaupunki;
                }
            
            
            
            public String setKaupunki(String kaupunki){
            return kaupunki;
            }
        
        }
 */
    
        public void readFinnKinoXML() {
            
            
            
           DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	   Date date = new Date();
           //kaupunki = "1002";
           String url = "http://www.finnkino.fi/xml/Schedule/?area="+kaupunki+"&dt="+dateFormat.format(date);
           
           
            try {
                DocumentBuilderFactory dbf = 
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
                
            doc.getDocumentElement().normalize();
            
            System.out.println ("Root element: " + 
                        doc.getDocumentElement().getNodeName());
            
            NodeList items = doc.getElementsByTagName("Show");
            for(int i = 0; i< items.getLength(); i++){
            
                Node n = items.item(i);
                if(n.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element e = (Element) n;
                
                NodeList titlelist  = e.getElementsByTagName("Theatre");
                Element titleElem = (Element) titlelist.item(0);
                
                Node titleNode = titleElem.getChildNodes().item(0);
                System.out.println(titleNode.getNodeValue());
                
                tieto = titleNode.getNodeValue();

                
            }
            
            
                
            } 
            catch (Exception e) {}
            
            
    }
}

