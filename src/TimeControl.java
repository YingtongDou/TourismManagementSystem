/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;


import java.awt.EventQueue;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import static journeyms.CentralControl.journeyList;

/**
 * Deal with the virtual time: each day starts at 8:00.
 * @author Group_94
 */
public class TimeControl {

    /**
     * 1 minute in virtual time equals to x/1000 seconds.
     */
    public static final int millisPerVirtualMinute = 500;
    SimpleDateFormat fmt = new SimpleDateFormat("hh-mm-ss");    String now = fmt.format(Calendar.getInstance().getTime());
    long startTimeMillis = System.currentTimeMillis();
    int realPassedSecond = 0;
    int hour = 8;
    int minute = 0;
        
    /**
     * Refresh every millisPerVirtualMinute seconds.
     */
    public TimeControl()
        {
            EventQueue.invokeLater(new Runnable() {  //Core to refresh 
            public void run() {
                try {

                        new Timer(delay, taskPerformer).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int delay = millisPerVirtualMinute; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //String s=String.format("%tY-%<tm-%<td   %<tH:%<tM:%<tS",new Date());
                    //System.out.println(s);
                    long nowTimeMillis= System.currentTimeMillis();
                    if ((nowTimeMillis-startTimeMillis)/millisPerVirtualMinute>=realPassedSecond)
                    {
                        realPassedSecond+=0.25;
                        minute+=1;
                    }
                    if (minute>=60)  
                    {
                        minute = 0;
                        hour+=1;
                    }
                    if (hour>=18)
                    {
                        hour=8;
                        for (int i=0;i<journeyList.size();i++)
                        {
                            journeyList.get(i).newDay();
                        }
                    }
                    //CentralControl.UI.setTitle("Journey Management System "+hour+":"+minute);
                    ///Show time in all panels.;
                    VirtualTime currentTime = new VirtualTime(hour, minute);
                    String currentTimeStr = String.format("%02d", hour)+":"+String.format("%02d", minute);
                    if (JourneyMS.TrainUI!=null&&JourneyMS.StationUI!=null)
                    {
                        CentralControl.UITimeShow(currentTimeStr);
                        JourneyMS.TrainUI.TrainLabelRefresh();
                        JourneyMS.StationUI.StationLabelRefresh();
                        CentralControl.journeyOperation(currentTime);
                    }
                    MainUI.TimeLabel3.setText(currentTimeStr);
                    //if (CentralControl.journeyList.isEmpty()!=true)
                    
                }
            };    
        });
        }

    /**
     *
     * @return
     */
    public VirtualTime CurrentTime()
        {
            return new VirtualTime(hour,minute);
        }
        
    /**
     *
     * @return
     */
    public String CurrentTimeInString()
        {
            return hour + ":" + minute;
        }

    /**
     *
     * @param t
     * @return
     */
    public VirtualTime getVirtualTimeFromString(String t)
        {
            String[] parts = t.split(":");
            VirtualTime vt = new VirtualTime(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
            return vt;
        }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int TimeCompare(VirtualTime a, VirtualTime b)
        {
            if((a!=null)&&(b!=null))
                return (a.gethour()-b.gethour())*60+(a.getminute()-b.getminute());
            else
            {
                if (a==null)
                    System.out.print("a is null");
                if (b==null)
                    System.out.print("b is null");
                return 0;
            }
        }

    /**
     *
     * @param a
     * @param min
     * @return
     */
    public static VirtualTime TimeAdd(VirtualTime a, int min)
        {
            if (a.getminute()+min%60<60)
                return new VirtualTime(a.gethour()+min/60,a.getminute()+min%60);
            else
                return new VirtualTime(a.gethour()+min/60+1,a.getminute()+min%60-60);
        }

}
