package dataProvidersPractice.dataProvidersPractice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class XlsReader {
		
		public Object[][] ReadData() throws IOException 
		{
			String username;
			String password;
			String filepath="D:\\";
			String filename="book1.xlsx";
			
			System.out.println(filepath+filename);
			File f=new File(filepath+"\\"+filename);
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=null;
			String fileextension=filename.substring(filename.indexOf("."));
			System.out.println(fileextension);
			
			
			if (fileextension.equalsIgnoreCase(".xlsx"))
				wb=new XSSFWorkbook(fis);
			else
				wb= new HSSFWorkbook(fis);
			Sheet s=wb.getSheetAt(0);
			Object[][] dt=new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
			
			int rowcount=s.getLastRowNum();
			System.out.println("rowcount::"+rowcount);
			for( int i=1;i<rowcount+1;i++)
			{
				System.out.println("asdgasdfas");
				username =s.getRow(i).getCell(0).getStringCellValue();
				password=s.getRow(i).getCell(1).getStringCellValue();
				dt[i-1][0]=username;
				dt[i-1][1]=password;
				System.out.println(dt[i-1][0]);
				System.out.println(dt[i-1][1]);
			}
			
				return dt;
				
			
			}
		public static void main(String[] args)throws IOException,FileNotFoundException {
			// TODO Auto-generated method stub
			XlsReader re=new XlsReader();
			String Filepath="D:\\";
			String Filename="book1.xlsx";
			String Sheetname="Sheet1";
			re.ReadData();

		}
		}