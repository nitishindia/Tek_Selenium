package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteData_InExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		File f = new File("‪‪‪‪C:\\Users\\dell\\Saved Games\\WriteBook.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w =  WorkbookFactory.create(fis);
		Row r = w.getSheet("Sheet1").getRow(1);
		Cell c = r.createCell(0);
		c.setCellType(CellType.STRING);
		c.setCellValue("Nitish");
		
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		fos.flush();
		w.close();
		System.out.println("===Executed successfully====");
	}

}
