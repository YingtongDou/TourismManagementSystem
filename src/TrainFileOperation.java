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
public class TrainFileOperation {
    static File trainFile = new File("Train.txt");

    /**
     *
     * @throws IOException
     */
    public static void readTrainList() throws IOException 
    {
	if (trainFile.exists()) 
        {
            BufferedReader reader = new BufferedReader(new FileReader(trainFile));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                Train train = getTrainFromString(line);
		CentralControl.trainList.add(train);
            }
            reader.close();
        }   
    }
    private static Train getTrainFromString(String line) 
    {
        String[] parts = line.split("\t");
	Train train = new Train(parts[0], Boolean.parseBoolean(parts[1]), new Station(parts[2]));
	return train;
    }
    
    /**
     *
     * @param trains
     * @throws IOException
     */
    public static void writeTrainList(List<Train> trains) throws IOException 
    {
	String data = "";
	for (int i=0; i<trains.size();i++) 
        {
            Train train = trains.get(i);
            data += train.getID()+"\t"+
                    train.getAvailability()+"\t"+
                    train.getTowardStation().getStation()+"\r\n";
	}
        FileWriter writer = new FileWriter(trainFile);
        writer.write(data);
	writer.close();
    }
}
