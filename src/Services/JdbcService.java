/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Concert;
import Models.Event;
import Models.Location;
import Models.Movie;
import Models.StandUpShow;
import Models.TheatrePlay;
import Models.Ticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teodora
 */
public class JdbcService {
    private EventService eventService;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public Ticket findClientsTicket(String qrySQL){
        Statement pstmt = null;
        Ticket ticket = null;
        try {
            
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineTicketsDB", "teodora", "teodora");
            pstmt = connection.createStatement();
            
            resultSet = pstmt.executeQuery(qrySQL);
            while(resultSet.next()){
               ticket =new Ticket(resultSet.getInt(1),
                        false,resultSet.getDouble("price"),
                        resultSet.getDouble("vip_price"),
                        resultSet.getString("seat"));
            }
            if(statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
            if(resultSet!=null)
                resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ticket;
    }

    public JdbcService(){
        eventService = EventService.getInstance();
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineTicketsDB", "teodora", "teodora");
            
            statement = connection.createStatement();
            
            String qrySQL = "select * from events e join locations l on (e.location_id = l.id)";
            
            resultSet = statement.executeQuery(qrySQL);
            
            while(resultSet.next()){
               Event event; 
               Location location = new Location(resultSet.getInt("id"),
                       resultSet.getString(9),resultSet.getString("city"),
                       resultSet.getString("country"));
               if(resultSet.getString("type").equals("concert")){
                   event = new Concert(resultSet.getInt("event_id"),resultSet.getString(2),
                       resultSet.getString("description"),resultSet.getDate("start_date"),resultSet.getDate("end_date"), location, null);
                    eventService.addEvent(event);
               }
               else
                   if(resultSet.getString("type").equals("movie")){
                       event = new Movie(resultSet.getInt("event_id"),resultSet.getString(2),
                       resultSet.getString("description"),resultSet.getDate("start_date"),resultSet.getDate("end_date"), location, null);
                    eventService.addEvent(event);
                   }
               else
                        if(resultSet.getString("type").equals("theatre")){
                            event = new TheatrePlay(resultSet.getInt("event_id"),resultSet.getString(2),resultSet.getString("description"),
                                    resultSet.getDate("start_date"),resultSet.getDate("end_date"), location, false);
                            eventService.addEvent(event);
                            
                       }
                        else{
                             event = new StandUpShow(resultSet.getInt("event_id"),resultSet.getString(2),resultSet.getString("description"),
                                     resultSet.getDate("start_date"),resultSet.getDate("end_date"), location, null);
                             eventService.addEvent(event);
                        }
               
            }
              
        } catch (SQLException ex) {
            System.out.println("Eroare la conectarea la BD: ");
            Logger.getLogger(JdbcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
            if(resultSet!=null)
                resultSet.close();
        } catch (SQLException ex) {
            System.out.println("Eroare la inchidere BD: ");
            Logger.getLogger(JdbcService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
