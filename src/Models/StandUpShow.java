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

public class StandUpShow extends Event {

    private String[] artists;

    public StandUpShow() { }

    public StandUpShow(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation, String[] artists) {
        super(id, name, smallDescription, startData, endDate, eventLocation);
        this.artists = artists;
    }

    @Override
    public String toString() {
        return //"artists=" + Arrays.toString(artists) + "\n" +
                super.toString();
    }

    public void makeNewEvent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of artists:");
        int nrArtists = scanner.nextInt();
        for(int i=0;i<nrArtists;i++)
            this.artists[i]=scanner.next();
        super.makeNewEvent();
    }
}

