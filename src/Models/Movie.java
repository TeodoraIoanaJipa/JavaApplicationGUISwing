/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Teodora
 */
public class Movie extends Event {

    private String[] type;

    public Movie() {
    }

    public Movie(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation, String[] type) {
        super(id, name, smallDescription, startData, endDate, eventLocation);
        this.type = type;
    }

    @Override
    public String toString() {
        return //"Movie{" + 
               // "type=" + Arrays.toString(type) + //'}' +  "\n" +
                super.toString();
    }

    public void makeNewEvent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of types of the movie (Drama, Thriller, Comedy, Science Fiction):");
        int numberOfTypes = scanner.nextInt();
        type=new String[numberOfTypes];
        for(int i=0;i<numberOfTypes;i++)
            this.type[i]=scanner.nextLine();
        super.makeNewEvent();
    }
}

