package theSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import queue.ArrayQueue;
import queue.SLLQueue;

public class TheSystemJobs {
	private static ArrayQueue<Jobs> inputQueue = new ArrayQueue<Jobs>();
	
	private static int numOfJobs;
	
	
	public static void main(String[] args) throws FileNotFoundException  {
        
		Scanner scanner1 = new Scanner(new File("C:/Users/micky/workspace/ICOM4035 Lab 6/input.csv"));
		Scanner scanner2 = new Scanner(new File("C:/Users/micky/workspace/ICOM4035 Lab 6/input2.csv"));
		Scanner scanner3 = new Scanner(new File("C:/Users/micky/workspace/ICOM4035 Lab 6/input3.csv"));
		Scanner scanner4 = new Scanner(new File("C:/Users/micky/workspace/ICOM4035 Lab 6/input4.csv"));
		getJobs(scanner1);
		numOfJobs = inputQueue.size();
		System.out.println("The average time for the first input file is:" + JobsQueue()/numOfJobs);
		
		getJobs(scanner2);
		numOfJobs = inputQueue.size();	
		System.out.println("The average time for the second input file is:" + JobsQueue()/numOfJobs);
		
		getJobs(scanner3);
		numOfJobs = inputQueue.size();
		System.out.println("The average time for the third input file is:" + JobsQueue()/numOfJobs);
		
		getJobs(scanner4);
		numOfJobs = inputQueue.size();
		System.out.println("The average time for the fourth input file is:" + JobsQueue()/numOfJobs);
		
		
		 
	}
	/*Reads the csv files and store the elements on a array queue*/
	public static void getJobs(Scanner scanner)throws FileNotFoundException{
    
        while(scanner.hasNext()){
        	String line = scanner.nextLine();
       String input[] = line.split(",");
          Jobs J = new Jobs(Integer.parseInt(input[0]),Integer.parseInt(input[1]),0);
          inputQueue.enqueue(J);
        }
        scanner.close();
	}
	
	/* Does the job simulation and then calculates the processing time of all jobs 
	 * and returns it.
	 */
	public static double JobsQueue() {
		SLLQueue<Jobs> processingQueue = new SLLQueue<Jobs>();      // Initialize an empty queue for processing jobs
		IndexList<Jobs> terminatedJobs= new ArrayIndexList<Jobs>();// Intialize an empty list for terminated jobs
		int time = 0;
		
		while(!inputQueue.isEmpty()||!processingQueue.isEmpty()){  
			if(!processingQueue.isEmpty()){						   
				int serviceTime = processingQueue.first().getServiceTime(); // Stores the service time of the first job on the queue.
				processingQueue.first().setServiceTime(serviceTime-1);      // Service the first job for one unit of time.
				if(processingQueue.first().getServiceTime()==0){			// Checks to see if the job is finished.
					Jobs terminatedJob = processingQueue.dequeue();			// Dequeue the first job and sets it departure time.
					terminatedJob.setDepartureTime(time);
					terminatedJobs.add(terminatedJob);						// Adds the finished job to the list of terminated jobs.
					
				}else{
					processingQueue.enqueue(processingQueue.dequeue());		// If the job is not finished, move it to the end of the queue.
				}
				
			}
			if(!inputQueue.isEmpty() && inputQueue.first().getArrivalTime()==time){  // Checks to see if job has the same arrival time as "time".
				processingQueue.enqueue(inputQueue.dequeue());						//Enqueue the job from inputQueue to processingQueue.
			}
			time = time +1;
		}
		
		
		double allJobsTime = 0;						
		for(int i = 0; i<terminatedJobs.size();i++){		// Calculates the processing time of all terminated jobs and adds them up.
			Jobs job = terminatedJobs.get(i);
			int totalTime = job.getDepartureTime() - job.getArrivalTime();
		allJobsTime = totalTime + allJobsTime;
	}
		
	return allJobsTime;
	}
	
	

}

	
