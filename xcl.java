package Git_Pract.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xcl {
	static WebDriver driver;
	   File src = new File("C:\\Users\\tanveer.shaikh\\Desktop\\Testing Stuff\\TestData.xls");

	public static void main(String []args) throws Exception{
		
		System.out.println("hello");
		xcl obj = new xcl();
		//obj.usingfor();
		
		
		
		
	}
	
	
	public void loginTest() throws Exception{
		
		xcl reader = new xcl();
		
		driver.get("https://accounts.google.com");
		
		
		
		
		
	}
public void usingfor(String row, String column) throws Exception{
		
		
		//File src = new File("C:\\Users\\tanveer.shaikh\\Desktop\\Testing Stuff\\TestData.xls");
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheetAt(0);
		int total = sh.getLastRowNum();
		int real = total+1;
		for (int i = 0; i<real ;i++){
		 row = sh.getRow(i).getCell(0).getStringCellValue();
		 column = sh.getRow(i).getCell(1).getStringCellValue();
		System.out.println("Username : "+row +"  "+ "Password : "+column);
		
		
		}}
	
	
public void usingiterator() throws Exception{
		
		FileInputStream fis = new FileInputStream(src);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheetAt(0);
		Iterator <Row> Rowiterator = sh.iterator();
		Rowiterator.next();
	
		while(Rowiterator.hasNext()){
			Row row = Rowiterator.next();
			
			Iterator<Cell> celliterator = row.cellIterator();
			while(celliterator.hasNext()){
				Cell cell = celliterator.next();
				switch(cell.getCellType()){
					
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print("Cell type is boolean : ");
					System.out.print(cell);
					break;
					
				case Cell.CELL_TYPE_STRING:
					System.out.print("Cell type is String : ");
					System.out.print(cell);
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print("Cell type is Numeric : ");
					System.out.print(cell);
					break;
					
				}
			
				System.out.print("  ");
			}
			System.out.println("");
		}
		
	
}
}
