/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

import java.util.*;

/**
 *
 * @author Group_94
 */
public class CentralControl {
       // static Map<String, Driver> driverList = new HashMap<String, Driver>();

    /**
     * Save driver information.
     */
    public static List<Driver> driverList = new ArrayList<Driver>();

    /**
     * Save train information.
     */
    public static List<Train> trainList = new ArrayList<Train>();

    /**
     * Save route information.
     */
    public static List<Route> routeList = new ArrayList<Route>();

    /**
     * Save journey information.
     */
    public static List<Journey> journeyList = new ArrayList<Journey>();

    /**
     * Save station information.
     */
    public static List<Station> stationList = new ArrayList<Station>();

    /**
     * Save the linking relationship information.
     */
    public static List<String[]> stationLinkList = new ArrayList<String[]>(); 

    /**
     * Initialize the CentralControlUI.
     */
    public static CentralControlUI UI = new CentralControlUI();

    /**
     * Update the time in all panels, called by TimeControl.
     * @param currentTimeStr
     */
    public static void UITimeShow(String currentTimeStr)
        {
            UI.TimeLabel.setText(currentTimeStr);
            UI.TimeLabel1.setText(currentTimeStr);
            UI.TimeLabel2.setText(currentTimeStr);
            JourneyMS.TrainUI.TimeLabel3.setText(currentTimeStr);
            JourneyMS.StationUI.TimeLabel3.setText(currentTimeStr);
        }

    /**
     * Synchronize all real-time information, called by TimeControl.
     * @param vt
     */
    public static void journeyOperation(VirtualTime vt)
        {
            for (int i=0;i<journeyList.size();i++)
            {
                journeyList.get(i).OperateWhenTimeComes(vt);
            }
        }
        
}
