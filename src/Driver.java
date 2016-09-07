/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;
import java.io.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author Group 94
 */
public class Driver {

    private String DriverID;
    private boolean Availability;
    private String name;
    private String gender;
    private String age;
    private Train onTrain;
    /**
     *Construction method.
     * @param ID
     */
    public Driver(String ID, boolean ava, String name, String gender, String age){
        this.DriverID=ID;
        this.Availability=ava;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.onTrain=null;
    }
    
    /**
     * Set the id of the driver
     * @param id 
     */
    public void setID(String id){
       this.DriverID = id;
   }
    /**
     *Get the User ID.
     * @return UserID
     */
    public String getID(){
       return this.DriverID;
   }
    
    /**
     *Set the user avalability
     * @param Availability
     */
    public void setAvailability(boolean Availability){
       this.Availability=Availability;
    }
    
    /**
     *Return the avalability.
     * @return avalability
     */
    public boolean getAvailability(){
       return this.Availability;
    }
     /**
     *Set the name.
     *@param name
     */
    public void setName(String name){
       this.name=name;
    }
    /**
     *Return the name.
     * @return name
     */
    public String getName(){
       return this.name;
    }
    
    /**
     *Get the gender of the driver
     * @param gender
     */
    public void setGender(String gender){
       this.gender=gender;
    }

    /**
     *
     * @return
     */
    public String getGender(){
       return this.gender;
    }
    
    /**
     *
     * @param age
     */
    public void setAge(String age){
       this.age=age;
    }

    /**
     *
     * @return
     */
    public String getAge(){
       return this.age;
    }

    /**
     *
     * @param train
     */
    public void setTrain(Train train)
    {
        this.onTrain = train;
    }

    /**
     *
     * @return
     */
    public Train getTrain()
    {
        return this.onTrain;
    }

    /**
     *When the journey is released, release the related driver info.
     */
    public void releaseJourney()
    {
        setAvailability(true);
        setTrain(null);
    }
}
