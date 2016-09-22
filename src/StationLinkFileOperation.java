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
public class StationLinkFileOperation {
    static File slFile = new File("StationLink.txt");

    /**
     *
     * @throws IOException
     */
    public static void readStationLinkList() throws IOException 
    {
	if (slFile.exists()) 
        {
            BufferedReader reader = new BufferedReader(new FileReader(slFile));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] stationLink = line.split("\t");
                //System.out.println(train.getTowardStation().getStation());
		CentralControl.stationLinkList.add(stationLink);   
            }
            String[] stationLink = CentralControl.stationLinkList.get(0);
            //System.out.println(stationLink[0]+" "+stationLink[1]+" "+stationLink[2]);
            reader.close();
        }   
    }
}
