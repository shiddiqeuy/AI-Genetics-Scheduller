package com.shiddiq.entity;

import javax.persistence.Column;

public class Node {

		@Column
	    private String name;
	 	
		@Column
	    private int readyness;

	    @Column
	    private int period;

	    @Column
	    private int executiontime;

	    @Column
	    private int deadline;
	    
	    @Column
	    private Boolean isready=false; //default value
	    
	    @Column
	    private int periodtemp=0; //default value

	    @Column
	    private int executiontimetemp=0; //default value
 
	    @Column
	    private int deadlinetemp=0; //default value
	    //add by shiddiq for GA parameter
	    @Column
	    private int tardiness=0; //default value
 
		public Node(String namein , int readynessin , int periodin , int executiontimein , int deadlinein ){
			this.name = namein;
			this.readyness = readynessin;
			this.period = periodin;
			this.executiontime = executiontimein;
			this.deadline = deadlinein;
			
		}
		
		public int getPeriodtemp() {
	        return periodtemp;
	    }
		
		public int setPeriodtemp(int periodtempin) {
	        return this.periodtemp=periodtempin;
	    }
		
		public int getExecutiontimetemp() {
	        return executiontimetemp;
	    }
		
		public int setExecutiontimetemp(int executiontimetempin) {
	        return this.executiontimetemp=executiontimetempin;
	    }
		
		public int getDeadlinetemp() {
	        return deadlinetemp;
	    }
		
		public int setDeadlinetemp(int deadlinetempin ) {
	        return deadlinetemp=deadlinetempin;
	    }
		
		
		public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public int getReadyness() {
	        return readyness;
	    }
	    
	    public void setReadyness(int readyness) {
	        this.readyness = readyness;
	    }
	    	    
	    
	    public int getPeriod() {
	        return period;
	    }
	    
	    public void setPeriod(int period) {
	        this.period = period;

	    }
	    
	    public void  decreasePeriodtime(){
	    		this.period = period-10;
	    		this.periodtemp = periodtemp+10;
	   }
	    
	    public int getExecutiontime() {
	        return executiontime;
	    }
	    
	    public void setExecutiontime(int executiontime) {
	        this.executiontime= executiontime;

	    }
	    
	    public void  decreaseExecutiontime(){	    	
	    		this.executiontime = executiontime-10; 
	    		this.executiontimetemp = executiontimetemp+10;
		   
	   }
	    
	    public int getDeadline() {
	        return deadline;
	    }
	    
	    public void setDeadline(int deadline) {
	        this.deadline = deadline;
	    }
	    
	    public void  decreaseDeadline(){ 
	    		this.deadline = deadline-10;
	    		this.deadlinetemp = deadlinetemp + 10;
	   }
	   
	    public Boolean getReady() {
	        return isready;
	    }
	    
	    public void setReady(Boolean isreadyin) {
	        this.isready = isreadyin;
	    }
	    
	    //add by shiddiq 
	    public int getTardiness() {
	        return tardiness;
	    }
	    
	    public void setTardiness() {
	         this.tardiness=executiontime-deadline;
	    }
	    
	    public String toString(){
	    	 return "{Nodename : "+name
	    			+ "Readyness :	"+readyness
	    			+ "Period : "+period
	    			+ "Execution time : "+executiontime
	    			+ "Deadline	: "+deadline
	    			+ "}";
	    		    	
	    }
	    
	    
}    


