package Git_Pract.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logger {
	
	public static void main(String[] args) throws Exception{
		
		logger obj = new logger();
		obj.taker();
		
		
		
	}
	
	
	public void taker() throws Exception{
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tanveer.shaikh\\Desktop\\Testing Stuff\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://mail.google.com/");
		
		ArrayList<String> userName = reader(0);
		ArrayList<String> password= reader(1);
	
		for(int i = 0;i<userName.size();i++){
			
			driver.get(userName.get(i));
			Thread.sleep(1000);
			driver.close();
			driver = new ChromeDriver();
			
			
		}
		/*driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(userName.get(i));
		driver.findElement(By.xpath(".//*[@id='next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys(password.get(i));
		driver.findElement(By.xpath(".//*[@id='signIn']")).click();
		}*/
	}
		
	public ArrayList<String> reader(int ColNo) throws Exception{
		FileInputStream fis = new FileInputStream("C:\\Users\\tanveer.shaikh\\Desktop\\Testing Stuff\\TestData.xls");
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sh.iterator();
		rowIterator.next();
		ArrayList<String> list = new ArrayList<String>();
		while(rowIterator.hasNext()){
			list.add(rowIterator.next().getCell(ColNo).getStringCellValue());
			
		}
		
		
		
		return list;
		
	}
	
	
	
	

}
