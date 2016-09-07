/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author charleszha
 */
public class Journey {
    private String id;
    private Route route;
    private Train train;
    private Driver driver;
    private int nextStationNo=0;
//    private Station towardStation;
    private VirtualTime startTime;
    private VirtualTime virtualTimeToNextOperation;
    private VirtualTime virtualTimeOfLastOperation;
    private Boolean IsFinished=false;
    private Boolean IsJourneyStarted=false;
    
//    int towardStationNo;
    //Time starttime;

    /**
     *
     * @param id
     * @param t
     * @param d
     * @param r
     * @param starttime
     */
    public Journey (String id, Train t, Driver d, Route r, VirtualTime starttime)
    {
        t.setAvailability(false);
        d.setAvailability(false);
        //r.setAvailability(false)
        this.id=id;
        this.route=r;
        this.train=t;
        t.setAvailability(false);
        this.driver=d;
        d.setTrain(train);
        this.startTime=starttime;
        this.virtualTimeToNextOperation=starttime; //Set the first Operation Time as the start time.
        this.virtualTimeOfLastOperation=null;
    }

    /**
     *
     * @param currentTime
     */
    public void OperateWhenTimeComes(VirtualTime currentTime)
    {
        if(this.virtualTimeToNextOperation!=null&&nextStationNo<route.getRoutes().size()) //If there is the next station
        {
            if (currentTime.gethour()==virtualTimeToNextOperation.gethour()&&
                currentTime.getminute()==virtualTimeToNextOperation.getminute()) // If it's time to start/stop
            {              
                virtualTimeOfLastOperation=currentTime;
                if (train.getStatus()==false) //If it is time to start (head for next station)
                {
                    this.IsJourneyStarted=true;
                    train.Start();
                    gotoNextStation();
                    calculateNextOperationTime(currentTime); 
                    if (nextStationNo<route.getRoutes().size())
                        System.out.println(currentTime.getTimeInString()+" "+
                            train.getID()+" is now heading for Station "+ route.getStation(nextStationNo).getStation());
                    JourneyMS.TrainUI.TrainLabelRefresh();
                }
                else if (train.IsMannuallyControlled()==false)//If it is time to stop (arrived)
                {
                    train.Stop();
                    stopAndGo(currentTime);
                    System.out.println(currentTime.getTimeInString()+" "+train.getID()+" has arrived at Station "+ 
                            route.getStation(nextStationNo).getStation());
                    JourneyMS.TrainUI.TrainLabelRefresh();
                }

            }
        }
    }

    /**
     *
     * @param currentTime
     */
    public void calculateNextOperationTime(VirtualTime currentTime) 
    {
        Boolean IsStationLinkFound=false;
        for (int i=0; i<=CentralControl.stationLinkList.size()-1; i++)
        {
            if ((getPreviousStation().getStation().equals(CentralControl.stationLinkList.get(i)[0]))&&
                    (getNextStation().getStation().equals(CentralControl.stationLinkList.get(i)[1])))
                {
                   virtualTimeToNextOperation = JourneyMS.timeControl.TimeAdd(currentTime,
                           Integer.parseInt(CentralControl.stationLinkList.get(i)[2]));
                   IsStationLinkFound=true;
                }
        }
        if (IsStationLinkFound==false)
        {
            System.out.println(currentTime.getTimeInString()+" "+getID()+
                        ": No link between " +getPreviousStation().getStation()+" and "+getNextStation().getStation());
            virtualTimeToNextOperation=null;
            IsFinished = true;
        }
    }

    /**
     *
     * @return
     */
    public Station getPreviousStation()
    {
        //if (nextStationNo==0)
       //    System.out.println(nextStationNo);
        //    return new Station("A",5);
        //else
        //System.out.println(route.getStation(nextStationNo-1).getStation());
        return route.getStation(nextStationNo-1);
    }

    /**
     *
     * @return
     */
    public Station getNextStation()
    {
        if (nextStationNo!=route.getTotalStations())
            return route.getStation(nextStationNo);
        else return(new Station("Off"));
    }

    /**
     *
     * @param currentTime
     */
    public void stopAndGo(VirtualTime currentTime)
    {
        virtualTimeToNextOperation = JourneyMS.timeControl.TimeAdd(currentTime,5);//Rest 5 min per stop
    }

    /**
     *
     */
    public void gotoNextStation()
    {
        if (nextStationNo<route.getTotalStations()-1)
        {
            nextStationNo+=1;
            train.setTowardStation(route.getStation(nextStationNo));
        }
        else nextStationNo=route.getTotalStations();
    }

    /**
     *
     */
    public void ArrivalTimePaused()
    {
        this.virtualTimeToNextOperation=null;
    }

    /**
     *
     * @return
     */
    public VirtualTime getTimeToNextOperation()
    {
        return this.virtualTimeToNextOperation;
    }

    /**
     *
     * @return
     */
    public VirtualTime getTimeOfLastOperation()
    {
        return this.virtualTimeOfLastOperation;
    }

    /**
     *
     */
    public void ReleaseJourney()
    {
        this.route.setAvailability(true);
        this.train.releaseJourney();
        this.driver.releaseJourney();
        this.route=null;
        this.train=null;
        this.driver=null;
    }

    /**
     *
     * @return
     */
    public String getID()
    {
        return this.id;
    }

    /**
     *
     * @return
     */
    public Train getTrain()
    {
        return this.train;
    }

    /**
     *
     * @return
     */
    public Driver getDriver()
    {
        return this.driver;
    }

    /**
     *
     * @return
     */
    public Route getRoute()
    {
        return this.route;
    }

    /**
     *
     * @return
     */
    public VirtualTime getStartTime()
    {
        return this.startTime;
    } 

    /**
     *
     * @return
     */
    public Boolean IsFinished()
    {
        return this.IsFinished;
    }

    /**
     *
     * @return
     */
    public Boolean IsJourneyStarted()
    {
        return this.IsJourneyStarted;
    }

    /**
     *
     * @return
     */
    public int GetNextStationNo()
    {
        return this.nextStationNo;
    }

    /**
     *
     */
    public void newDay()
    {
        this.nextStationNo=0;
        this.IsJourneyStarted=false;
        this.IsFinished=false;
        this.virtualTimeToNextOperation=this.startTime;
    }
}
