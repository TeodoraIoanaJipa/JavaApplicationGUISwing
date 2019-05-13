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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AuditService {
    private static AuditService ourInstance = new AuditService();

    public static AuditService getInstance() {
        return ourInstance;
    }

    private AuditService() {
    }

    public void writeToFile(String filePath,String action){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath, true);
            BufferedWriter out = new BufferedWriter(fileWriter);

            Date currentDate = new Date();
            out.write(action + ','+ currentDate.toString());
            out.newLine();
            out.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

