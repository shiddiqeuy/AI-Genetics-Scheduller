/**
 * 
 */
package com.shiddiq.dao.impl;

import com.shiddiq.dao.IsasensorDAO;
import com.shiddiq.entity.Isasensor;
import com.shiddiq.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shiddiq
 * @version 4.0
 */

@Repository
public class IsasensorDAOImpl implements IsasensorDAO {
    
	public IsasensorDAOImpl() {
    	System.out.println("IsasensorDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createIsasensor(Isasensor isasensor) {        
        return (long) hibernateUtil.create(isasensor);
    }
    
    @Override
    public Isasensor updateIsasensor(Isasensor isasensor) {        
        return hibernateUtil.update(isasensor);
    }
    
    @Override
    public void deleteIsasensor(long id) {
        Isasensor isasensor = new Isasensor();
        isasensor.setId(id);
        hibernateUtil.delete(isasensor);
    }
    
    @Override
    public List<Isasensor> getAllIsasensors() {        
        return hibernateUtil.fetchAll(Isasensor.class);
    }
    
    @Override
    public Isasensor getIsasensor(long id) {
        return hibernateUtil.fetchById(id, Isasensor.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Isasensor> getAllIsasensors(String id) { 
		String query = "SELECT e.* FROM isasensors e WHERE e.id like '%"+ id +"%'";
		List<Object[]> isasensorObjects = hibernateUtil.fetchAll(query);
		List<Isasensor> isasensors = new ArrayList<Isasensor>();
		for(Object[] isasensorObject: isasensorObjects) {
			Isasensor isasensor = new Isasensor();
           
			int isaid = ((int) isasensorObject[0]);
            int phase = ((int) isasensorObject[1]);
            int period = ((int) isasensorObject[2]);
            int executiontime = ((int) isasensorObject[3]);
            int deadline = ((int) isasensorObject[4]);
       
           

            isasensor.setId(isaid);
            isasensor.setPhase(phase);
            isasensor.setPeriod(period);
            isasensor.setExecutiontime(executiontime);
            isasensor.setDeadline(deadline);
			
			isasensors.add(isasensor);
		}
		System.out.println(isasensors);
		return isasensors;
	}
}