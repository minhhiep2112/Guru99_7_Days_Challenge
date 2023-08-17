package data_driven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class GetData {
	
	@DataProvider(name="example_data")
	public String[][] get_data() throws IOException{
		
		FileInputStream f = new FileInputStream("./Data/testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		int rows = sheet1.getPhysicalNumberOfRows();
		
		String[][] testdata = new String[rows][2];
		
		for(int i=0;i<rows;i++) {
			
			XSSFRow row = sheet1.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			
			testdata[i][0] = username.toString();
			testdata[i][1] = password.toString();
			
			
		}
		wb.close();
		return testdata;
		
		
	}
	
}
