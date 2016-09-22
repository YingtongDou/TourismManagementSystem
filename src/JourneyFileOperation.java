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
public class JourneyFileOperation {
    static File journeyFile = new File("Journey.txt");

    /**
     *
     * @throws IOException
     */
    public static void readJourneyList() throws IOException 
    {
	if (journeyFile.exists()) 
        {
            BufferedReader reader = new BufferedReader(new FileReader(journeyFile));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                Journey journey = getJourneyFromString(line);
		CentralControl.journeyList.add(journey);
            }
            reader.close();
        }   
    }
    private static Journey getJourneyFromString(String line) 
    {
        String[] parts = line.split("\t");
        Train t=null; Driver d=null; Route r=null; VirtualTime vt;
        for (int i=0;i<CentralControl.trainList.size();i++)
        {
            if (CentralControl.trainList.get(i).getID().equals(parts[1])) t = CentralControl.trainList.get(i);
        }
        for (int i=0;i<CentralControl.driverList.size();i++)
        {
            if (CentralControl.driverList.get(i).getID().equals(parts[2])) d =  CentralControl.driverList.get(i);
        }
        for (int i=0;i<CentralControl.routeList.size();i++)
        {
            if (CentralControl.routeList.get(i).getID().equals(parts[3])) r  =  CentralControl.routeList.get(i);
        }
        vt = JourneyMS.timeControl.getVirtualTimeFromString(parts[4]);
	Journey journey = new Journey(parts[0], t, d, r, vt);
	return journey;
    }
    
    /**
     *
     * @param journeys
     * @throws IOException
     */
    public static void writeJourneyList(List<Journey> journeys) throws IOException 
    {
	String data = "";
	for (int i=0; i<journeys.size();i++) 
        {
            Journey journey = journeys.get(i);
            data += journey.getID()+"\t"+
                    journey.getTrain().getID()+"\t"+
                    journey.getDriver().getID()+"\t"+
                    journey.getRoute().getID()+"\t"+
                    journey.getStartTime().getTimeInString()+"\r\n";
	}
		FileWriter writer = new FileWriter(journeyFile);
		writer.write(data);
		writer.close();
    }
}
