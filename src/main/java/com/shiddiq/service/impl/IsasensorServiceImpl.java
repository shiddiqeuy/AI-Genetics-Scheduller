package com.shiddiq.service.impl;
import com.shiddiq.dao.IsasensorDAO;
import com.shiddiq.entity.Isasensor;
import com.shiddiq.service.IsasensorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author shiddiq 
 * @version 2.0
 */
@Service
@Transactional
public class IsasensorServiceImpl implements IsasensorService {
	
	public IsasensorServiceImpl() {
		System.out.println("IsasensorServiceImpl()");
	}
	
    @Autowired
    private IsasensorDAO isasensorDAO;

    @Override
    public long createISAsensor(Isasensor isasensor) {
        return isasensorDAO.createIsasensor(isasensor);
    }
    @Override
    public Isasensor updateISAsensor(Isasensor isasensor) {
        return isasensorDAO.updateIsasensor(isasensor);
    }
    @Override
    public void deleteISAsensor(long id) {
        isasensorDAO.deleteIsasensor(id);
    }
    @Override
    public List<Isasensor> getAllIsasensors() {
        return isasensorDAO.getAllIsasensors();
    }
    @Override
    public Isasensor getIsasensor(long id) {
        return isasensorDAO.getIsasensor(id);
    }    
    @Override
    public List<Isasensor> getAllIsasensors(String id) {
    	return isasensorDAO.getAllIsasensors(id);
    }
}
