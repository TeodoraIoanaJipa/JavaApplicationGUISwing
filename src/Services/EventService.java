/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Teodora
 */
import Models.*;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private List<Event> eventsList;
    private Integer nextEventId = 0;

    private static EventService ourInstance = new EventService();

    public static EventService getInstance() {
        return ourInstance;
    }

    private EventService() {
        eventsList=new ArrayList<>();
    }

    public void addEvent(Event event){
        try {
            eventsList.add(event);
        }catch(NullPointerException ex){
            System.out.println("NULL event");
        }
    }

    public List<Event> getEventsList() {
        return eventsList;
    }

    public void printAllEvents(List<Event> eventList){
        int nr=0;
        for (Event event : eventList) {
            System.out.println(++nr +". " + event.toString());
        }
    }

    public void printAll(List<? extends Event> eventList){
        int nr=0;
        for (Event event : eventList) {
            System.out.println(++nr +". " + event.toString());
        }
    }

    public List<Event> getEventsListByCountry(String country){
        List<Event>EventsListByCountry=new ArrayList<>();
        for (Event event : eventsList) {
            if (event.getEventLocation().getCountry().toLowerCase().equals(country))
                EventsListByCountry.add(event);
        }
        return EventsListByCountry;
    }

    public List<Event> getEventsListByCity(String city){
        List<Event>EventsListByCity=new ArrayList<>();
        for (Event event : eventsList) {
            if (event.getEventLocation().getCity().toLowerCase().equals(city))
                EventsListByCity.add(event);
        }
        return EventsListByCity;
    }

    public List<Concert> getAllConcerts(){
        List<Concert> concerts = new ArrayList<>();
        for (Event event : eventsList)
            if(event instanceof Concert)
                concerts.add((Concert) event);
        return concerts;
    }


    public List<? extends Event> getAllMovies(){
        List<Event> movies = new ArrayList<>();
        for (Event event : eventsList)
            if( event instanceof Movie)
                movies.add((Movie) event);
        return movies;
    }


    public List<StandUpShow> getAllStandUps(){
        List<StandUpShow> standups = new ArrayList<>();
        for (Event event : eventsList)
            if( event instanceof StandUpShow)
                standups.add((StandUpShow) event);
        return standups;
    }


    public List<TheatrePlay> getAllTheatrePlays(){
        List<TheatrePlay> plays = new ArrayList<>();
        for (Event event : eventsList)
            if( event instanceof TheatrePlay)
                plays.add((TheatrePlay) event);
        return plays;
    }


}

