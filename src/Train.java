/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;
import java.text.DecimalFormat;
import java.util.*;
/**
 *
 * @author Group_94
 */
public class Train {
    private String TrainID;
    private boolean IsAvailable;
    private Station TowardStation;
    private boolean IsRunning;
    private boolean IsMannuallyControled = false;
    
    /**
     *Construction method.
     * @param ID
     */
    public Train(String ID, Boolean Ava, Station ts){
        this.TrainID=ID;
        this.IsAvailable=Ava;
        this.TowardStation=new Station("A");
        this.IsRunning=false;
    }
    
    /**
     *Get the Train ID.
     * @return UserID
     */
    public String getID(){
       return this.TrainID;
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
    
    /**
     *
     * @param st
     */
    public void setTowardStation(Station st){
        this.TowardStation=st;
    }
        
    /**
     *
     * @return
     */
    public Station getTowardStation(){
        return this.TowardStation;
    }
            
    /**
     *
     */
    public void releaseJourney()
    {
        this.TowardStation=new Station("A");
        this.IsAvailable=true;
    }

    /**
     *
     */
    public void Stop()
    {
        this.IsRunning=false;
        this.IsMannuallyControled=false;
    }

    /**
     *
     */
    public void Start()
    {
        this.IsRunning=true;
        this.IsMannuallyControled=false;
    }

    /**
     *
     * @return
     */
    public Boolean getStatus()
    {
        return this.IsRunning;
    }

    /**
     *
     * @return
     */
    public String showSpeed()
    {
            double r = 20*(Math.random());
            double s =120+r;
            double speed = Math.round(s);
            DecimalFormat format = new DecimalFormat("#.0");
            if (this.IsRunning==true) return format.format(speed);
            else return "0";
    }

    /**
     *
     */
    public void mannualyStopTrain()
    {
        this.IsMannuallyControled=true;
        this.IsRunning=false;
    }

    /**
     *
     */
    public void mannualyStartTrain()
    {
        this.IsMannuallyControled=false;
        this.IsRunning=true;
    }

    /**
     *
     * @return
     */
    public Boolean IsMannuallyControlled()
    {
        return this.IsMannuallyControled;
    }
}
