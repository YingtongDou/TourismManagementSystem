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
public class RouteFileOperation {
    static File routeFile = new File("Route.txt");

    /**
     *
     * @throws IOException
     */
    public static void readRouteList() throws IOException 
    {
	if (routeFile.exists()) 
        {
            BufferedReader reader = new BufferedReader(new FileReader(routeFile));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                Route route = getRouteFromString(line);
		CentralControl.routeList.add(route);
            }
            reader.close();
        }   
    }
    private static Route getRouteFromString(String line) 
    {
        String[] parts = line.split("\t");
        String stations="";
        for (int i=1;i<parts.length-1;i++)
            stations+=parts[i]+" ";
        stations+=parts[parts.length-1];
	Route route = new Route(parts[0],stations);
	return route;
    }
    
    /**
     *
     * @param routes
     * @throws IOException
     */
    public static void writeRouteList(List<Route> routes) throws IOException 
    {
	String data = "";
	for (int i=0; i<routes.size();i++) 
        {
            Route route = routes.get(i);
            data += route.getID()+"\t"+
                    route.writeRoutesInFile()+"\r\n";
	}
        FileWriter writer = new FileWriter(routeFile);
        writer.write(data);
	writer.close();
    }
}
