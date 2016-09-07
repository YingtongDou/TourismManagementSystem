/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;
import java.util.*;
/**
 *
 * @author charleszha
 */
public class Route {
    private String ID;
    //List<Station> routeToSave;
    private List<Station> route = new ArrayList<Station>();
    private Boolean IsAvailable;
    private int totalStations;

    /**
     *
     * @param ID
     * @param r
     */
    public Route(String ID, String r)
    {
        this.ID=ID;
        String[] parts = r.split(" ");
        totalStations = parts.length;
        for (int i=0; i<parts.length;i++)
            route.add(i,new Station(parts[i]));
    //    for (int i=parts.length-2; i>=0; i--)
    //    route.add(new Station(parts[i]));
        IsAvailable=true;
    }

    /**
     *
     * @param ID
     * @param r
     * @param b
     */
    public Route(String ID, String r, Boolean b)
    {
        this.ID=ID;
        String[] parts = r.split(" ");
        totalStations = parts.length;
        for (int i=0; i<parts.length;i++)
            route.add(i,new Station(parts[i]));
        for (int i=parts.length-2; i>=0; i--)
            route.add(new Station(parts[i]));
        IsAvailable=true;
    }

    /**
     *
     * @return
     */
    public List<Station> getRoutes()
    {
        return route;
    }

    /**
     *
     * @return
     */
    public String getRoutesInString()
    {
        String r="";
        for (int i=0;i<route.size()-1;i++)
            r+=route.get(i).getStation()+"->";
        r+=route.get(route.size()-1).getStation();
        return r;
    }

    /**
     *
     * @return
     */
    public String writeRoutesInFile()
    {
        String r="";
        for (int i=0;i<route.size()-1;i++)
            r+=route.get(i).getStation()+"\t";
        r+=route.get(route.size()-1).getStation();
        return r;
    }

    /**
     *
     * @return
     */
    public String getID(){
       return this.ID;
    }

    /**
     *
     * @param i
     * @return
     */
    public Station getStation(int i)
    {
        if (i<route.size()&&i>=0)
            return route.get(i);
        else return null;
    }

    /**
     *
     * @return
     */
    public int getTotalStations()
    {
        return this.totalStations;
    }
    /**
     *Set the availability.
     * @param IsAvailable
     */
    public void setAvailability(boolean IsAvailable){
        this.IsAvailable=IsAvailable;
   }
    
    /**
     *Return the availability.
     * @return availability
     */
    public boolean getAvailability(){
       return this.IsAvailable;
   }
}
