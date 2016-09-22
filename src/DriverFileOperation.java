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
public class DriverFileOperation {
    static File driverFile = new File("Driver.txt");

    /**
     * Read driver text from file.
     * @throws IOException
     */
    public static void readDriverList() throws IOException 
    {
	if (driverFile.exists()) 
        {
            BufferedReader reader = new BufferedReader(new FileReader(driverFile));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                Driver driver = getDriverFromString(line);
		CentralControl.driverList.add(driver);
            }
            reader.close();
        }   
    }
    private static Driver getDriverFromString(String line) 
    {
        String[] parts = line.split("\t");
	Driver driver = new Driver(parts[0], Boolean.parseBoolean(parts[1]), parts[2], parts[3], parts[4]);
	return driver;
    }
    
    /**
     * Write driver information in text file.
     * @param drivers
     * @throws IOException
     */
    public static void writeDriverList(List<Driver> drivers) throws IOException 
    {
	String data = "";
	for (int i=0; i<drivers.size();i++) 
        {
            Driver driver = drivers.get(i);
            data += driver.getID()+"\t"+
                    driver.getAvailability()+"\t"+
                    driver.getName()+"\t"+
                    driver.getGender()+"\t"+
                    driver.getAge()+"\r\n";
	}
	FileWriter writer = new FileWriter(driverFile);
	writer.write(data);
	writer.close();
    }
}
