/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

/**
 *
 * @author Asmo
 */
public class OmdbElokuva {
    private String title;
    private String director;
    
    public OmdbElokuva(String title, String director){
        this.title = title;
        this.director = director;
    
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public void tulostaElokuva() {
        System.out.println("CD:n tiedot:");
        System.out.println("************");
        System.out.println("Title:"+this.title);
        System.out.println("Ohjaaja:"+this.director);
        
    }
}
