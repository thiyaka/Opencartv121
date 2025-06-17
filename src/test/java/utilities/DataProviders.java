package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	

	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException{
		
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil= new ExcelUtility(path);
		
		int totalrows= xlutil.getRowCount("Sheet2");
		int totalcol=xlutil.getCellCount("Sheet2",1);
		
		String logindata [][]= new String[totalrows][totalcol];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0; j<totalcol;j++) {
				logindata[i-1][j]= xlutil.getCellData("Sheet2", i, j);
			}
		}
		
		return logindata;
				
	}
	
}
