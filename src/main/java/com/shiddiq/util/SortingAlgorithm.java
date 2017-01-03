package com.shiddiq.util;
import java.util.List;

import com.shiddiq.entity.Node;

public class SortingAlgorithm {
	
	public static List<Node> BubbleSortNode (List<Node> ArrayNodeArg){
		Boolean Swap = true;
		int j = 0;
		Node temp;
		
		while (Swap){
			Swap = false;
			j++;
				for (int i = 0 ; i < ArrayNodeArg.size()-j;i++){					
					if (ArrayNodeArg.get(i).getDeadline()>ArrayNodeArg.get(i+1).getDeadline()) {
						temp = ArrayNodeArg.get(i);
						ArrayNodeArg.set(i, ArrayNodeArg.get(i+1))  ;
						ArrayNodeArg.set(i+1,temp) ;
						Swap=true;										
					}
				}			
		}		
		return ArrayNodeArg;
	}
	
	public static List<Node> BubbleSortNodeTardiness (List<Node> ArrayNodeArg){
		Boolean Swap = true;
		int j = 0;
		Node temp;
		
		while (Swap){
			Swap = false;
			j++;
				for (int i = 0 ; i < ArrayNodeArg.size()-j;i++){					
					if (ArrayNodeArg.get(i).getTardiness()>ArrayNodeArg.get(i+1).getTardiness()) {
						temp = ArrayNodeArg.get(i);
						ArrayNodeArg.set(i, ArrayNodeArg.get(i+1))  ;
						ArrayNodeArg.set(i+1,temp) ;
						Swap=true;										
					}
				}			
		}		
		return ArrayNodeArg;
	}

}
