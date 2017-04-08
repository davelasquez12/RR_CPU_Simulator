/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //1. Set context switching and time quantum values array
        int[] csVals = {0, 5, 10, 15, 20, 25};
        int[] timeQtms = {50, 100, 250, 500};
        
        List<DataResult> resultList = new ArrayList<>(24);
        
        //2. Read in data set from text file
        LinkedList<Process> processQueue = loadProcessQueue();
        
        //3. Run RRSimulations for each context switch and each time quantum value
        for(int i = 0; i < csVals.length; i++)
        {
            int csTime = csVals[i];
            
            for(int j = 0; j < timeQtms.length; j++)
            {
                int timeQtm = timeQtms[j];
                LinkedList<Process> processQueueCopy = copyList(processQueue);
                DataResult result = new RRSimulation(csTime, timeQtm, processQueueCopy).execute();
                resultList.add(result);
            }
        }
        
        //4. Write data in resultList to text file.
        saveResults(resultList);
    }
    
    //Reads in times.txt, stores the times in a Process List, and returns it.
    private static LinkedList<Process> loadProcessQueue()
    {
        LinkedList<Process> processQueue = new LinkedList<>();
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("times.txt"));
            String line = br.readLine();
            while(line != null)
            {
                try
                {
                    String[] times = line.split("  ");  //split on two space chars
                    Process process = new Process(Integer.parseInt(times[0]), Double.parseDouble(times[1]));
                    processQueue.add(process);
                }catch(Exception e)
                {
                    System.out.println("Error parsing line.");
                }
                
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return processQueue;
    }
    
    private static LinkedList<Process> copyList(LinkedList<Process> list)
    {
        LinkedList<Process> listCopy = new LinkedList<>();
        for(Process process : list)
        {
            listCopy.add(new Process(process));
        }
        
        return listCopy;
    }
    
    private static void saveResults(List<DataResult> dataResults)
    {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter(
                 new OutputStreamWriter(
                 new FileOutputStream("dataResults.txt"), "utf-8"));
            
            StringBuilder strBldr = null;
            
            for(DataResult dataResult : dataResults)
            {
                strBldr = new StringBuilder();
                strBldr.append(dataResult.getCsTime() + ",");
                strBldr.append(dataResult.getTimeQtm() + ",");
                strBldr.append(dataResult.getAvgWaitTime() + ",");
                strBldr.append(dataResult.getAvgTurnArndTime());
                writer.write(strBldr.toString());
                writer.newLine();
            }
        }catch(IOException e)
        {
            System.out.println("Error creating file.");
        }
        finally{
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
        
    }
}
