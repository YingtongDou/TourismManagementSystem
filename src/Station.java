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
public class Station {
    private String Name;
    private int stopMin;

    /**
     *
     * @param name
     */
    public Station(String name)
    {
        this.Name=name;
        this.stopMin=5;
    }

    /**
     *
     * @param name
     * @param stopmin
     */
    public Station(String name, int stopmin)
    {
        this.Name=name;
        this.stopMin=stopmin;
    }

    /**
     *
     * @param name
     */
    public void setStation(String name)
    {
        this.Name=name;
    }
    
    /**
     *
     * @return
     */
    public String getStation()
    {
        return this.Name;
    }

    /**
     *
     * @return
     */
    public int getStopMinutes()
    {
        return this.stopMin;
    }
}
