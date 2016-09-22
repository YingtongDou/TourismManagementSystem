/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Group_94
 */
public class StationFileOperation {
    static File stationFile = new File("Station.txt");

    /**
     *
     * @throws IOException
     */
    public static void readStationList() throws IOException 
    {
	if (stationFile.exists()) 
        {
            BufferedReader reader = new BufferedReader(new FileReader(stationFile));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] s = line.split("\t");
                for (int i=0;i<s.length;i++)
                    CentralControl.stationList.add(new Station(s[i]));   
            }
            reader.close();
        }   
    }
}