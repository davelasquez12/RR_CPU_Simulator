/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj2;

import java.util.LinkedList;

/**
 *
 * @author David
 */
public class RRSimulation {
    private int csTime;
    private int timeQuantum;
    private LinkedList<Process> processQueue;
    private DataResult dataResult;
   
    public RRSimulation(int csTime, int timeQuantum, LinkedList<Process> processQueue) 
    {
        this.csTime = csTime;
        this.timeQuantum = timeQuantum;
        this.processQueue = processQueue;
    }

    public int getCsTime() {
        return csTime;
    }

    public void setCsTime(int csTime) {
        this.csTime = csTime;
    }

    public int getTimeQuantum() {
        return timeQuantum;
    }

    public void setTimeQuantum(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public LinkedList<Process> getProcessQueue() {
        return processQueue;
    }

    public void setProcessQueue(LinkedList<Process> processQueue) {
        this.processQueue = processQueue;
    }
    
    public DataResult execute()
    {
        Process process;
        while(processQueue.size() != 0)
        {
            process = processQueue.removeFirst();
            
        }
        return null;
    }

    public DataResult getDataResult() {
        return dataResult;
    }

    public void setDataResult(DataResult dataResult) {
        this.dataResult = dataResult;
    }
}
