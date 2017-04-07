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

    public DataResult(int csTime, int timeQtm, double avgWaitTime, double avgTurnArndTime) 
    {
        this.csTime = csTime;
        this.timeQtm = timeQtm;
        this.avgWaitTime = avgWaitTime;
        this.avgTurnArndTime = avgTurnArndTime;
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
