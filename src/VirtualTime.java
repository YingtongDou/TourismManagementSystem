/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journeyms;

/**
 * Transfer integers into virtual time, with hour and minute.
 * @author Group_94
 */
public class VirtualTime {
    private int hour;
    private int minute;
    VirtualTime(int h, int m)
    {
        this.hour = h;
        this.minute = m;
    }
    VirtualTime(String t)
    {
            String[] parts = t.split(":");
            this.hour = Integer.parseInt(parts[0]);
            this.minute = Integer.parseInt(parts[1]);
    }

    /**
     * Return hour.
     * @return
     */
    public int gethour()
    {
        return this.hour;
    }

    /**
     * Return minute in integer.
     * @return
     */
    public int getminute()
    {
        return this.minute;
    }

    /**
     * Obtain time in String format, XX:XX.
     * @return
     */
    public String getTimeInString()
    {
        String s = String.format("%02d", this.hour)+":"+String.format("%02d", this.minute);
        return s;
    }
 
}
