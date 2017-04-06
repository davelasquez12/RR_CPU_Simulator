/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        List<Process> processQueue = loadProcessQueue();
        
        //3. Run RRSimulations for each context switch and each time quantum value
        for(int i = 0; i < csVals.length; i++)
        {
            int csTime = csVals[i];
            
            for(int j = 0; j < timeQtms.length; j++)
            {
                int timeQtm = timeQtms[j];
                DataResult result = new RRSimulation(csTime, timeQtm, processQueue).execute();
                resultList.add(result);
            }
        }
        
        //4. Write data result list to text file.
    }
    
    //Reads in times.txt, stores the times in a Process List, and returns it.
    public static List<Process> loadProcessQueue()
    {
        List<Process> processQueue = new ArrayList<>();
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
    
    //public static void executeSims(List<Process>)
}
