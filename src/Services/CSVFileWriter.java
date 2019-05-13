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

import Models.Event;

import java.io.*;

public class CSVFileWriter {
    private static CSVFileWriter ourInstance = new CSVFileWriter();

    public static CSVFileWriter getInstance() {
        return ourInstance;
    }

    private CSVFileWriter() {
    }

    public void writeToFile(String filePath, Event myevent ) throws IOException {

        FileWriter fileWriter = new FileWriter(filePath, true);
        BufferedWriter out = new BufferedWriter(fileWriter);

        out.write(myevent.toString());
        out.newLine();

        out.close();
        fileWriter.close();

    }
}

