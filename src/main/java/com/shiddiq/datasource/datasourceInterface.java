package com.shiddiq.datasource;

import java.util.List;

import com.shiddiq.entity.Node;
import com.shiddiq.util.ReadExcel;

public interface datasourceInterface {
	
	public List<Node> readDatasource(String Directoryin);
	public void generateDatasource(int numberOfNodes,String Directoryout,int MaxValueArg);

}