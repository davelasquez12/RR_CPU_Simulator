/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj2;

/**
 *
 * @author David
 */
public class DataResult {
    private int csTime;
    private int timeQtm;
    private double avgWaitTime;
    private double avgTurnArndTime;
    public static final int WAIT_TIME_PLOT = 0;
    public static final int TURN_AROUND_TIME_PLOT = 1;

    public DataResult(int csTime, int timeQtm, double avgTime, int plotSignal) 
    {
        this.csTime = csTime;
        this.timeQtm = timeQtm;
        
        if(plotSignal == 0)
        {
            this.avgWaitTime = avgTime;
            this.avgTurnArndTime = -1;
        }
        else
        {
            this.avgWaitTime = -1;
            this.avgTurnArndTime = avgTime;
        }
    }
    

    public int getCsTime() {
        return csTime;
    }

    public void setCsTime(int csTime) {
        this.csTime = csTime;
    }

    public int getTimeQtm() {
        return timeQtm;
    }

    public void setTimeQtm(int timeQtm) {
        this.timeQtm = timeQtm;
    }

    public double getAvgWaitTime() {
        return avgWaitTime;
    }

    public void setAvgWaitTime(double avgWaitTime) {
        this.avgWaitTime = avgWaitTime;
    }

    public double getAvgTurnArndTime() {
        return avgTurnArndTime;
    }

    public void setAvgTurnArndTime(double avgTurnArndTime) {
        this.avgTurnArndTime = avgTurnArndTime;
    }
}
