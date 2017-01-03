package com.shiddiq.service;
import com.shiddiq.entity.Isasensor;
import java.util.List;

/**
 * @author shiddiq 
 * @version 2.0
 */
public interface IsasensorService {
	public long createISAsensor(Isasensor isasensor);
    public Isasensor updateISAsensor(Isasensor isasensor);
    public void deleteISAsensor(long id);
    public List<Isasensor> getAllIsasensors();
    public Isasensor getIsasensor(long id);	
	public List<Isasensor> getAllIsasensors(String ledid);
}
