package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rownum, int celNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/TestDataAA4.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		String data = w.getSheet(sheetName).getRow(rownum).getCell(celNum).getStringCellValue();
		return data;		
	}
	
	
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testdata/TestDataAA4.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		int rowcount = w.getSheet(sheetName).getLastRowNum();
		return rowcount;
	}
	
	
	public String setDataIntoExcel(String sheetName, int rownum, int celNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./testdata/TestDataAA4.xlsx");
	Workbook w = WorkbookFactory.create(fis);
	 w.getSheet(sheetName).getRow(rownum).createCell(celNum);
	 
	 FileOutputStream fos = new FileOutputStream("./testdata/TestDataAA4.xlsx");
	 w.write(fos);
	 w.close();
	 return sheetName;
	}
	
}
