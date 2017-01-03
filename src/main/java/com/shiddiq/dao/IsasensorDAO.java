package com.shiddiq.dao;
import java.util.List;
import com.shiddiq.entity.Isasensor;

/**
 * @author shiddiq 
 * @version 2.0
 */
public interface IsasensorDAO {
    public long createIsasensor(Isasensor isasensor);
    public Isasensor updateIsasensor(Isasensor isasensor);
    public void deleteIsasensor(long id);
    public List<Isasensor> getAllIsasensors();
    public Isasensor getIsasensor(long id);   
    public List<Isasensor> getAllIsasensors(String id);
}
