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
import java.util.Date;
import java.util.Scanner;

public class TheatrePlay extends Event {

    Boolean improvizatie;

    public TheatrePlay() {
    }

    public TheatrePlay(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation, Boolean improvizatie) {
        super(id, name, smallDescription, startData, endDate, eventLocation);
        this.improvizatie = improvizatie;
    }

    @Override
    public String toString() {
        return //"TheatrePlay{" + "improvizatie=" + improvizatie + '}' + 
                super.toString();
    }

    public void makeNewEvent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is is an improvisation? Type 0 if NO, 1 if YES");
        while(true){
            if (scanner.nextInt() ==0) {
                improvizatie = false;
                break;
            }
            else
                if (scanner.nextInt() ==1) {
                    improvizatie = true;
                    break;
                }
                else {
                    System.out.println("You did not enter a valid choice for the improvisation.");
                }
        }

        super.makeNewEvent();
    }
}

