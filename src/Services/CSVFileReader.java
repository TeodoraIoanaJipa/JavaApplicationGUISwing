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

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CSVFileReader {
    private static CSVFileReader ourInstance = new CSVFileReader();

    public static CSVFileReader getInstance() {
        return ourInstance;
    }

    private CSVFileReader() {
    }

    public void readFromFile(String filePath, EventService eventService) {

        try {
            FileReader fileReader;
            fileReader = new FileReader(filePath);

            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
            String line = lineNumberReader.readLine();

            while (line != null) {

                String[] arguments = line.split(",");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String type = arguments[0];

                switch (type) {
                    case "1": {
                        String[] artisti;
                        artisti = new String[arguments.length - 10];

                        if (arguments.length - 10 >= 0)
                            System.arraycopy(arguments, 10, artisti, 0, arguments.length - 10);

                        Event event = new Concert(Integer.parseInt(arguments[1]), arguments[2], arguments[3],
                                simpleDateFormat.parse(arguments[4]), simpleDateFormat.parse(arguments[5]),
                                new Location(Integer.parseInt(arguments[6]), arguments[7], arguments[8], arguments[9]), artisti);
                        eventService.addEvent(event);

                        break;
                    }
                    case "2": {
                        String[] movieTypes;
                        movieTypes = new String[arguments.length - 10];

                        for (int i = 10; i < arguments.length; i++)
                            movieTypes[i - 10] = arguments[i];
                        Event event = new Movie(Integer.parseInt(arguments[1]), arguments[2], arguments[3],
                                simpleDateFormat.parse(arguments[4]), simpleDateFormat.parse(arguments[5]),
                                new Location(Integer.parseInt(arguments[6]), arguments[7], arguments[8], arguments[9]), movieTypes);
                        eventService.addEvent(event);
                        break;
                    }
                    case "3": {
                        String[] artisti;
                        artisti = new String[arguments.length - 10];

                        for (int i = 10; i < arguments.length; i++)
                            artisti[i - 10] = arguments[i];

                        Event event = new StandUpShow(Integer.parseInt(arguments[1]), arguments[2], arguments[3],
                                simpleDateFormat.parse(arguments[4]), simpleDateFormat.parse(arguments[5]),
                                new Location(Integer.parseInt(arguments[6]), arguments[7], arguments[8], arguments[9]), artisti);
                        eventService.addEvent(event);
                        break;
                    }
                    case "4": {
                        Boolean improvisation;
                        if (arguments[10].equals("0"))
                            improvisation = false;
                        else
                            improvisation = true;
                        Event event = new TheatrePlay(Integer.parseInt(arguments[1]), arguments[2], arguments[3],
                                simpleDateFormat.parse(arguments[4]), simpleDateFormat.parse(arguments[5]),
                                new Location(Integer.parseInt(arguments[6]), arguments[7], arguments[8], arguments[9]), improvisation);
                        eventService.addEvent(event);
                        break;
                    }
                    default: {
                        /*
                        Event event = new Event(Integer.parseInt(arguments[1]), arguments[2], arguments[3],
                                simpleDateFormat.parse(arguments[4]), simpleDateFormat.parse(arguments[5]),
                                new Location(Integer.parseInt(arguments[6]), arguments[7], arguments[8], arguments[9]));
                        eventService.addEvent(event);*/
                        break;
                    }
                }

                line = lineNumberReader.readLine();
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }


}

