/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;

/**
 *
 * @author Group_94
 */
public class JourneyMS {

    /**
     * Initialize the main UI.
     */
    public static MainUI mainUI = new MainUI();

    /**
     * Initialize the time control, calculating the virtual time.
     */
    public static TimeControl timeControl=null;

    /**
     * Initialize the Station Control UI.
     */
    public static StationControlUI StationUI=null;

    /**
     * Initialize the Train Control UI.
     */
    public static TrainControlUI TrainUI=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        timeControl = new TimeControl();
        mainUI.setVisible(true);
        try {
            RouteFileOperation.readRouteList();
            TrainFileOperation.readTrainList();
            DriverFileOperation.readDriverList();
            JourneyFileOperation.readJourneyList();
            StationFileOperation.readStationList();
            StationLinkFileOperation.readStationLinkList();
	} catch (IOException e1) {
            e1.printStackTrace();
	}
        StationUI = new StationControlUI();
        TrainUI = new TrainControlUI();
    }
    
    
}
