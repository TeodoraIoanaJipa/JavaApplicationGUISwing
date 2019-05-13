package Models;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Teodora
 */
public class Event {
    private int id;
    private String name;
    private String smallDescription;
    private Date startDate;
    private Date endDate;
    private Location eventLocation;

    public Event() {}

    public Event(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation) {
        this.id = id;
        this.name = name;
        this.smallDescription = smallDescription;
        this.startDate = startData;
        this.endDate = endDate;
        this.eventLocation = eventLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(Location eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        SimpleDateFormat dt = new SimpleDateFormat("EEEE, dd MMMM yy hh:mm");
        return name + ". Cand? " + dt.format(startDate) +
                ", pana la " + dt.format(endDate) + ", Unde?" + eventLocation + "\n";
    }

    public void makeNewEvent(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Type eventID: ");
        try {
            this.id = scanner.nextInt();
            System.out.println("Type the name of the event: ");
            this.name = scanner.next();
            System.out.println("Type the description of the event: ");
            this.smallDescription = scanner.nextLine();
            System.out.println("Type the month: ");
            Date date = new Date();
            date.setMonth(scanner.nextInt());
            System.out.println("Type the day: ");
            date.setDate(scanner.nextInt());
            System.out.println("Type the hour: ");
            date.setHours(scanner.nextInt());
            this.startDate = date;
            this.endDate = date;
            System.out.println("Type the id of the location: ");
            int locationId = scanner.nextInt();
            System.out.println("Type the name of the location: ");
            String locationName = scanner.next();
            System.out.println("Type city: ");
            String city = scanner.next();
            System.out.println("Type country: ");
            String country = scanner.next();
            this.eventLocation = new Location(locationId, locationName, city, country);
        }catch(InputMismatchException exception){
            System.out.println("Input Mismatch Exception");
        }

    }
}
