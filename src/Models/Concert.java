/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Teodora
 */

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Concert extends Event {

    private String[] Artists;

    public Concert() {
    }

    public Concert(String[] artists) {
        super();
        Artists = artists;
    }

    public Concert(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation, String[] artists) {
        super(id, name, smallDescription, startData, endDate, eventLocation);
        Artists = artists;
    }

    public String[] getArtists() {
        return Artists;
    }

    public void setArtists(String[] artists) {
        Artists = artists;
    }

    @Override
    public String toString() {
        return //"Concert{" + "Artists=" + Arrays.toString(Artists) //+ '}' + "\n" + 
                super.toString();
    }

    public void makeNewEvent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of artists:");
        int nrArtists = scanner.nextInt();
        for(int i=0;i<nrArtists;i++)
            this.Artists[i]=scanner.next();
        super.makeNewEvent();
    }
}

