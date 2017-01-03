package com.shiddiq.schedulingAlgorithm;

import java.util.ArrayList;
import java.util.List;

import com.shiddiq.entity.Node;
import com.shiddiq.util.SortingAlgorithm;

public class DMSGA {
	
	public static String[][] SequencerGA(int rowsize , int colsize , List<Node> ArrayNode){

		String[][] M = new String[rowsize][colsize]; 
		int row = 0;
		int column = 0;
		boolean stopper = false;
		int indexarray = 0;
		String valuetemp = "";
		ArrayList MissDeadlineList = new ArrayList();
		String[] Superframe = new String[colsize];
		
		
		List<Node> ArrayNodeSort  =  new ArrayList<Node>(ArrayNode);
		ArrayNodeSort =  SortingAlgorithm.BubbleSortNode(ArrayNodeSort);
		
		System.out.println("Before Sort based on deadline");
		
		for (Node nodename : ArrayNode){
				
				System.out.println("Node name = "+nodename.getName()+ 
						" Period = "+nodename.getPeriod()+
						" Execution = "+nodename.getExecutiontime()+
						" Deadline  = "+nodename.getDeadline()+
						" Readytime = "+nodename.getReadyness());
				
		
		}
			System.out.println("\n");
			System.out.println(" After Sort based on deadline ");
			
		int[] indexpointer = new int[ArrayNodeSort.size()];
		int[] indexpointerGA = new int[ArrayNodeSort.size()];
		int t = 0;
		
		for (int i = 0 ; i < ArrayNodeSort.size();i++){
					//indexpointer[t]=
					System.out.println("Node name = "+ArrayNodeSort.get(i).getName()+ 
							" Period = "+ArrayNodeSort.get(i).getPeriod()+
							" Execution = "+ArrayNodeSort.get(i).getExecutiontime()+
							" Deadline  = "+ArrayNodeSort.get(i).getDeadline()+
							" Readytime = "+ArrayNodeSort.get(i).getReadyness());	
					int size = ArrayNodeSort.get(i).getName().length();
					String nametemp = ArrayNodeSort.get(i).getName();
					indexpointer[i] = 	i ;
					System.out.println("indexpointer[i]"+indexpointer[i]);
					t++;
			
			}
	
			Boolean isScheduled=false;
			Boolean fill =  true;
			Boolean isReady = false;


			while (!stopper ){	
				
				if (row<rowsize){
					indexarray=indexpointer[row];
					int size  = ArrayNodeSort.get(indexarray).getName().length();
					String nametemp = ArrayNode.get(indexarray).getName();
					//update by sid 
					nametemp = String.valueOf(nametemp.charAt(nametemp.length()-1));
					valuetemp = nametemp;
					
					System.out.println("column loop"+row);
						if(ArrayNode.get(indexarray).getReadyness()/10==column && ArrayNode.get(indexarray).getReady()==false){
							
							isReady = true;

							
							ArrayNode.get(indexarray).setReady(isReady);
								if(ArrayNode.get(indexarray).getPeriod()!= 0 ){
									if(ArrayNode.get(indexarray).getDeadline()!= 0 ){
										if (fill!=false){

											M[indexpointer[row]][column]="[ "+valuetemp+" ]";
											Superframe[column]="[ "+valuetemp+" ]";
											ArrayNode.get(indexarray).decreaseExecutiontime();
											ArrayNode.get(indexarray).decreasePeriodtime();
											ArrayNode.get(indexarray).decreaseDeadline();
												
											fill = false;
										}else{
											//ArrayNode.get(indexarray).decreaseExecutiontime();
											ArrayNode.get(indexarray).decreasePeriodtime();
											ArrayNode.get(indexarray).decreaseDeadline();
											//empty timeslot
											M[indexpointer[row]][column]="[   ]";
											
										}
									}
								}
							}else if(ArrayNode.get(indexarray).getReady()==true ){
									//startcalculatingtardiness
								
								   
										ArrayNode.get(indexarray).setTardiness();
									//endcalculatingtardines
										if(fill!=false){
											if (ArrayNode.get(indexarray).getPeriod()!= 0){
												ArrayNode.get(indexarray).decreasePeriodtime();
												if(ArrayNode.get(indexarray).getDeadline()!= 0 ){
													ArrayNode.get(indexarray).decreaseDeadline();
													if(ArrayNode.get(indexarray).getExecutiontime()!= 0 ){
														
														M[indexpointer[row]][column]="[ "+valuetemp+" ]";
														Superframe[column]="[ "+valuetemp+" ]";
														ArrayNode.get(indexarray).decreaseExecutiontime();
														
														fill = false;
													}else{
														//empty timeslot
														M[indexpointer[row]][column]="[   ]";
													}
												}else{
													//empty timeslot
													M[indexpointer[row]][column]="[   ]";
												}
											}
										}else{

											//ArrayNode.get(indexarray).decreaseExecutiontime();
											ArrayNode.get(indexarray).decreasePeriodtime();
											ArrayNode.get(indexarray).decreaseDeadline();
											//empty timeslot
											M[indexpointer[row]][column]="[   ]";
										}
							}else{
								//empty timeslot
								M[indexpointer[row]][column]="[   ]";
							}
								

					System.out.println(" value  temp node c d t fill readyflag = "
							+ArrayNode.get(indexarray).getName()+" "+
							+ArrayNode.get(indexarray).getExecutiontimetemp()+" "
							+ArrayNode.get(indexarray).getDeadlinetemp()+" "
							+ArrayNode.get(indexarray).getPeriodtemp()+" "
							+ArrayNode.get(indexarray).getReady()+" "
							+fill+" "+
							" Tardiness (Execution - Deadline  ) =  "+Integer.toString(ArrayNodeSort.get(indexarray).getTardiness()));
					
//							try {
//								
//								System.out.println("["+indexpointer[row]+"]["+column+"] <== "+M[indexpointer[row]][column]);
//								////Thread.sleep(10);
//								
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
					//restart node value here 
							
						if (ArrayNode.get(indexarray).getReady()==true&&ArrayNode.get(indexarray).getPeriod()==0)	{
							
							//calculate miss 
							if (ArrayNode.get(indexarray).getExecutiontime()>0){
								String result = ArrayNode.get(indexarray).getName()+" Tardiness -> Miss Target With Deadline "+ArrayNode.get(indexarray).getDeadline()+
										" and computation left = "+ArrayNode.get(indexarray).getExecutiontime()+" at timeslot no  "+column;
								System.out.println(result);
								MissDeadlineList.add(result);
							}

							
							System.out.println("restart value");
							System.out.println("restart value node c d t fill readyflag = "
									+ArrayNode.get(indexarray).getName()+" "
									+ArrayNode.get(indexarray).getExecutiontime()+" "
									+ArrayNode.get(indexarray).getDeadline()+" "
									+ArrayNode.get(indexarray).getPeriod()+" "
									+ArrayNode.get(indexarray).getReady()+" "
									+fill+" ");
														
							ArrayNode.get(indexarray).setPeriod(ArrayNode.get(indexarray).getPeriodtemp());
							ArrayNode.get(indexarray).setExecutiontime(ArrayNode.get(indexarray).getExecutiontimetemp());
							ArrayNode.get(indexarray).setDeadline(ArrayNode.get(indexarray).getDeadlinetemp());
							ArrayNode.get(indexarray).setPeriodtemp(0);
							ArrayNode.get(indexarray).setExecutiontimetemp(0);
							ArrayNode.get(indexarray).setDeadlinetemp(0);
							System.out.println("after restart value node c d t fill readyflag = "
									+ArrayNode.get(indexarray).getName()+" "
									+ArrayNode.get(indexarray).getExecutiontime()+" "
									+ArrayNode.get(indexarray).getDeadline()+" "
									+ArrayNode.get(indexarray).getPeriod()+" "
									+ArrayNode.get(indexarray).getReady()+" "
									+fill+" ");
						}
					//
					row++;					
				}else{
					
					row=0;
						if(column<colsize-1){
							fill = true;//restart flag every iteration 
							column++;
							//sort indexarray
								int hit = 0;
								for (Node node : ArrayNode){
									if (node.getReady()==true)
											hit++;
									
								}
								if(hit==ArrayNode.size()){
										List<Node> ArrayNodeSortGA  =  new ArrayList<Node>(ArrayNode);
										ArrayNodeSortGA =  SortingAlgorithm.BubbleSortNodeTardiness(ArrayNodeSortGA);
										for (int i = 0 ; i < ArrayNodeSortGA.size();i++){
											//indexpointer[t]=
											System.out.println("sort based on tardiness start ");
											int size = ArrayNodeSortGA.get(i).getName().length();
											String nametemp = ArrayNodeSortGA.get(i).getName();
											indexpointer[i] = 	i;
											System.out.println("indexpointer["+i+"] = "+indexpointer[i]);
											t++;
									
									}
								}
							//endsortindexarray
							
							
						}else{
							
							stopper=true;
							
						}
				}	
			}
			
			
			System.out.println("\n");
			System.out.println("===============================================================================");
			for (int i = 0 ; i <MissDeadlineList.size() ; i++ ){
				System.out.println("Sequencer result = "+MissDeadlineList.get(i));
			}

			System.out.println("===============================================================================");
			System.out.println("Superframe Result");
			System.out.println("===============================================================================");
			for(int z = 0;z < colsize ;z++ ){
//				try {
//					if(Superframe[z]!=null){
//					 System.out.print(Superframe[z]+" ");
//					}else{
//						System.out.print(Superframe[z]="[   ] ");
//					}
//					////Thread.sleep(5);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			
			}
			System.out.print("\n");
			return M;
		}
	

}
