package com.shiddiq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
/**
 * @author shiddiq 
 * @version 1.0
 * 
 */
@Entity
@Table(name = "isasensors")
public class Isasensor implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225147L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int phase;

    @Column
    private int period;

    @Column
    private int executiontime;

    @Column
    private int deadline;
    
   

    public Isasensor() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
  
    public int getPhase() {
        return phase;
    }
    public void setPhase(int phase) {
        this.phase = phase;
    }
    
    public int getPeriod() {
        return period;
    }
    public void setPeriod(int period) {
        this.period = period;
    }


    public int getExecutiontime() {
        return executiontime;
    }
    public void setExecutiontime(int executiontime) {
        this.executiontime = executiontime;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    
    @Override
    public String toString() {
        return "Isasensor{" +
                "id=" + id +
                ", phase='" + phase + '\'' +
                ", period=" + period +
                ", executiontime=" + executiontime +
                ", deadline=" + deadline +
                '}';
    }
}