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
        double waitTimeTotal = 0, turnArndTimeTotal = 0;
        int totalProcesses = processQueue.size();
        double timeElapsed = 0;
        
        while(processQueue.size() != 0)
        {
            process = processQueue.removeFirst();   //get next process in the queue
            
            if(process.getWaitTime() == 0)      //if true, this process is being used by the CPU for the first time, so set its wait time
            {
                if(timeElapsed < process.getArrivalTime())
                {
                    double CPUWaitingTime = process.getArrivalTime() - timeElapsed;
                    timeElapsed += CPUWaitingTime;
                    process.setWaitTime(timeElapsed - process.getArrivalTime());
                }
                else
                {
                    process.setWaitTime(Math.abs(timeElapsed - process.getArrivalTime()));
                }
                
                waitTimeTotal += process.getWaitTime();     //update the total wait time
            }
        
            if(timeQuantum < process.getSimTime())      //process did not complete within the time quantum
            {
                process.setSimTime(process.getSimTime() - timeQuantum);    //update remaining CPU time required by process to complete
                processQueue.addLast(process);          //add process to end of queue
                timeElapsed += timeQuantum;             //current process took up the entire time quantum so add that time to the timeElapsed
            } 
            else                                         //process completed within the time quantum
            {
                timeElapsed += process.getSimTime();    //since process completed, add the remaining sim time to timeElapsed
                turnArndTimeTotal += (timeElapsed - process.getArrivalTime());
            }
            
            timeElapsed += csTime;                      //add the time needed for each context switch
        }
        
        //Calculate averages
        double avgWaitTime = waitTimeTotal / totalProcesses;
        double avgTurnArndTime = turnArndTimeTotal / totalProcesses;
        return new DataResult(csTime, timeQuantum, avgWaitTime, avgTurnArndTime);
    }

    public DataResult getDataResult() {
        return dataResult;
    }

    public void setDataResult(DataResult dataResult) {
        this.dataResult = dataResult;
    }
}
