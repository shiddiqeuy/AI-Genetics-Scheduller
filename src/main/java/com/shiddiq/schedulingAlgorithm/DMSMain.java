package com.shiddiq.schedulingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shiddiq.util.*;

import com.shiddiq.entity.Node;

public class DMSMain {
	final static int numberoftimeslot= 500;//edit number of timeslot here
	//edit data source location below
	final static List<Node> ArrayofNode = ReadExcel.ReadExcel("D:\\ISA_GBS\\datasource\\datasourceshiddiq5.xls");
	
	public static void main(String[] args) {
		System.out.println("===============================================================================");
		System.out.println("Node Size = "+ArrayofNode.size());

		Map<String, Integer> mapreadytime = new HashMap<String, Integer>();
		Map<String, Integer> mapdeadlines = new HashMap<String, Integer>();
		String StartSuperframewith ="";
		
			for (Node nodename : ArrayofNode){
				
				System.out.println("Node name = "+nodename.getName()+ 
						" Period = "+nodename.getPeriod()+
						" Execution = "+nodename.getExecutiontime()+
						" Deadline  = "+nodename.getDeadline()+
						" Readytime = "+nodename.getReadyness());	
				
				mapreadytime.put(nodename.getName(),nodename.getReadyness());
				mapdeadlines.put(nodename.getName(),nodename.getDeadline());
				
			
			}
			
		String[] tempvalueready = new String[ArrayofNode.size()];
		Map<String, Integer> HashMapInit = new HashMap<String, Integer>();

		
		
		System.out.println("\n");
		Integer minr = Collections.min(mapreadytime.values());
		System.out.println("minimal ready time = "+minr); // 0.1
		Integer mind = Collections.min(mapdeadlines.values());
		System.out.println("minimal deadline = "+mind);
		//Start FCFS
		//mapping sequencer 
		//queue
		
		System.out.println("\n");
		System.out.println("===============================================================================");
		System.out.println("Initializing Scheduling");
		System.out.println("===============================================================================");
		//Scheduling on DMS Start Here 
		//superframe
		System.out.println("\n");
		System.out.println("Generating Superframe\n");
		String[] Superframe = new String[numberoftimeslot];
		//init value
		//cari node yang ready time nya paling duluan 
		//pastinya beacon sih 
		
		for(int z = 0;z < numberoftimeslot ;z++ ){
			 Superframe[z]= "[ ]";
		}
		
		//print superframe 
		for(int z = 0;z < numberoftimeslot ;z++ ){
			try {
				 System.out.print(Superframe[z]);
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		System.out.println("\n");
		
		//superframe
		String[][] matrix = new String[ArrayofNode.size()][numberoftimeslot];

		
		try {
			System.out.println("===============================================================================");
			System.out.println("Generating timeslot");
			System.out.println("===============================================================================");
			Thread.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//matrix=DMS.Sequencer(ArrayofNode.size(), numberoftimeslot , ArrayofNode);
		matrix=DMSGA.SequencerGA(ArrayofNode.size(), numberoftimeslot , ArrayofNode);
	
		System.out.println("===============================================================================");
		System.out.println("Generating Gantt Chart");
		System.out.println("===============================================================================");
		for (int i = 0; i < ArrayofNode.size(); i++) {
		    for (int j = 0; j < numberoftimeslot; j++) {
		    	
		    	try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	
	
	}

}
