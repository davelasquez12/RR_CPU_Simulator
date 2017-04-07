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
public class Process {
    private int arrivalTime;
    private double simTime;        //CPU time this process needs to complete
    private double waitTime;       //Time when process executes first - arrival time
    private double turnArndTime;   //Time when process completed - arrival time

    public Process(int arrivalTime, double simTime)
    {
        waitTime = 0;
        this.arrivalTime = arrivalTime;
        this.simTime = simTime;
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getSimTime() {
        return simTime;
    }

    public void setSimTime(double simTime) {
        this.simTime = simTime;
    }

    public double getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(double waitTime) {
        this.waitTime = waitTime;
    }

    public double getTurnArndTime() {
        return turnArndTime;
    }

    public void setTurnArndTime(double turnArndTime) {
        this.turnArndTime = turnArndTime;
    }
    
    
}
