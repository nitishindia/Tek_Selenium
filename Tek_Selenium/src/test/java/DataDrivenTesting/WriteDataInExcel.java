package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataInExcel {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\Write.xlsx");

		Workbook w = WorkbookFactory.create(fis);

		Sheet sh = w.getSheet("Sheet1");
		Row r = sh.getRow(1);
		Cell cel = r.createCell(5);
//		cel.toString();
//		System.out.println(cel);

//		String name = w.getSheet("Sheet1").getRow(1).getCell(2).toString();
//		System.out.println(name);

		FileOutputStream fos = new FileOutputStream("C:\\Users\\dell\\Desktop\\Write.xlsx");
		cel.setCellType(CellType.STRING);
		cel.setCellValue("Welcome");
		w.write(fos);
		w.close();
		System.out.println("===executed===");

	}

}
