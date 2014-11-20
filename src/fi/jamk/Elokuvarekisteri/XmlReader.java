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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**

/**
 *
 * @author Mikko2
 */
public class XmlReader {

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
            System.out.println(data.getAttribute("actors"));

        } catch (Exception e) {
        }
    }
    
    public void getMovieXml(String movieName) throws TransformerConfigurationException, TransformerException{
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
    }
}

