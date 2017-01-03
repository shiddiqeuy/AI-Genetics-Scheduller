package com.shiddiq.datasource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.shiddiq.entity.Node;
import com.shiddiq.util.ReadExcel;

public class datasourceImpl implements datasourceInterface {
	
	@Override
	public List<Node> readDatasource(String Directoryin) {
		// TODO Auto-generated method stub
		List<Node> ArrayNode = ReadExcel.ReadExcel(Directoryin);
		return ArrayNode;
	}


	@Override
	public void generateDatasource(int numberOfNodes, String Directoryout,int MaxValueArg) {
		
		// TODO Auto-generated method stub
		List<Node> ArrayofNode = new ArrayList<Node>();
		float utilization =  0;
		 //(int i = 0 ; i < numberOfNodes ; i++) 
		 Boolean loop = true;
		 int i =0;
		 Boolean flag1 = true;
		 Boolean flag2 = true;
		 while(loop){
			//logic 1 untuk pertama kali generate beacon
			//Random rand = new Random();//random integer
			 System.out.println("i  = "+i);
			 System.out.println("utilization  = "+utilization);
			if (i==0){
				//logic 2 generate rundom integer , dan aturannya U < 1
				
				int  r = (int) (Math.round((Math.random()*(MaxValueArg-10)+10)/10)*10);
				float  p = 0;
				float  c =  0;
				int  d =  (int) (Math.round((Math.random()*(MaxValueArg-10)+10)/10)*10);
					
					while(flag1){
						System.out.println("flag 0= "+flag1);
						 c = d;
						 System.out.println("c1 = "+c);
						 p = d+20;
						 System.out.println("p1  = "+p);
						if(c/p <1){
							System.out.println("masuk if end while 1 c/p"+c+"/"+p);
							flag1 = false;
							System.out.println("flag 1= "+flag1);
						}else{
							c = c - 10;
							if (d<p){
								p = p + 10;
							}else {
								p = p - 10;
							}
						}
						
					}	
					
				Node node = new Node("beacon", r, Math.round(p), Math.round(c), d);
				utilization = utilization + c/d;
				ArrayofNode.add(node);
			}else{
			//setelah generate beacon 
				 System.out.println("done generate beacon pertama");
			int  r = (int) (Math.round((Math.random()*(MaxValueArg-10)+10)/10)*10);
			float  p = 0;
			float  c =  0;
			int  d =  (int) (Math.round((Math.random()*(MaxValueArg-10)+10)/10)*10);
				//logic 2 generate rundom integer , dan aturannya U < 1
			
			while(flag2){
				 c = d;
				 System.out.println("i= "+i+" c2 = "+c);
				 p = d;
				 System.out.println("i= "+i+"p2 = "+p);
				 System.out.println("["+i+"] utilization while ke 2 = "+utilization);
				if(utilization + c/p <1){
					flag2 = false;
				}else{
					c = c - 10;
					if (d<p){
						p = p + 10;
					}else {
						p = p - 10;
					}
					
				}
				
			}
			String Nodename = "Node"+ Integer.toString(i);
			Node node = new Node("beacon", r, Math.round(p), Math.round(c), d);
			utilization = utilization + c/d;
			System.out.println("["+i+"] utilization = "+utilization);
			System.out.println("float c/p = "+c+"/"+p+" ="+Float.valueOf(c/p) );
			ArrayofNode.add(node);
			}
			if(utilization>0.95 && i==numberOfNodes-2){
				i=0;
				ArrayofNode.clear();
				System.out.println("Restart Random Node");
				flag1=true;
				flag2=flag1;
				utilization=0;
				
			}else if(utilization < 1){
				i++;
			}
						
		}
		System.out.println("\n");
		System.out.println("Data Source Creation done");
		System.out.println("utilization final= "+utilization);
		System.out.println("===========================================================================================");
		for (Node node : ArrayofNode){
			//print element
			node.toString();
			System.out.println("{' name' : "+node.getName()
								+" ' readytime' : "+node.getReadyness()
								+" ' period' : "+node.getPeriod()
								+" ' execution time' : "+node.getExecutiontime()
								+" ' deadline' : "+node.getDeadline()
								+"}");
			
			
		}
		//write to excel 
		
		
	}
	
	
	

}
