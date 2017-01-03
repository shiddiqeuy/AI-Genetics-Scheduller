package com.shiddiq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.shiddiq.entity.Node;

public class ReadExcel {
	
	public static List<Node> ReadExcel(String inputPath){
		List<Node> ArrayofNode = new ArrayList<Node>();
		System.out.println("Reading data from excel file");
		System.out.println("===============================================================================");
try {
			//D:\\ISA_GBS\\datasource\\
			FileInputStream file = new FileInputStream(new File(inputPath));
			
			//Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			//Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				String Nodename = "";
				int[] paramtime = new int[4];
				int index = 0;
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType()) {

						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t\t");
							int temp = (int) cell.getNumericCellValue();
							paramtime[index]=temp;
							index++;
							break;
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t\t");
							Nodename=cell.getStringCellValue();
							break;
					}
					
				}
				System.out.println("");
				//add to array
				Node nodedata = new Node(Nodename,paramtime[0],paramtime[1],paramtime[2],paramtime[3]);
				ArrayofNode.add(nodedata);
			}
			file.close();
			FileOutputStream out = 
				new FileOutputStream(new File(inputPath));
			workbook.write(out);
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return ArrayofNode;
	}
}
