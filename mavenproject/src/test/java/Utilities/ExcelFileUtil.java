package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil 
{
	Workbook wb;
	//constructor
	//it will load the excel sheet
	public ExcelFileUtil() throws Throwable{
		
	FileInputStream fis=new FileInputStream("./TestInputs/InputSheet.xlsx");
	wb=WorkbookFactory.create(fis);

    }
	public int rowCount(String Sheetname)
	{
		return wb.getSheet(Sheetname).getLastRowNum();
		
	}
	public int colCount(String Sheetname,int rowNo)
	{
		return wb.getSheet(Sheetname).getRow(rowNo).getLastCellNum();
	
	}
	  public String getData(String Sheetname,int row,int column)
	  {
		  String data="";
		  if(wb.getSheet(Sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
		  {
			  int celldata=(int)wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
			  data=String.valueOf(celldata);
		  }
		  else
		  {
			  data=wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue(); 
		  }
		  return data; 
	  }
	  public void setData(String Sheetname,int row,int column,String Status) throws Throwable
	  {
		  Sheet sh=wb.getSheet(Sheetname);
		  Row rownum=sh.getRow(row);
		  Cell cell=rownum.createCell(column);
		  cell.setCellValue(Status);
		  if(Status.equalsIgnoreCase("Pass"))
		  {
			  CellStyle style=wb.createCellStyle();
			  Font font=wb.createFont();
			  //apply color to the text
			  font.setColor(IndexedColors.GREEN.getIndex());
			  //apply bold to the text
			  font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			  style.setFont(font);
			  rownum.getCell(column).setCellStyle(style);
			  
		  }
		  else
			  if(Status.equalsIgnoreCase("Fail"))
			  {
				  CellStyle style=wb.createCellStyle();
				  Font font=wb.createFont();
				  //apply color to the text
				  font.setColor(IndexedColors.RED.getIndex());
				  //apply bold to the text
				  font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				  style.setFont(font);
				  rownum.getCell(column).setCellStyle(style);
			  }	
			  else
				  if(Status.equalsIgnoreCase("Not Executed"))
				  {
					  CellStyle style=wb.createCellStyle();
					  Font font=wb.createFont();
					  //apply color to the text
					  font.setColor(IndexedColors.BLUE.getIndex());
					  //apply bold to the text
					  font.setBoldweight(Font.BOLDWEIGHT_BOLD);
					  style.setFont(font);
					  rownum.getCell(column).setCellStyle(style);
				  }
		  FileOutputStream fos=new FileOutputStream("./TestOutputs/OutputSheet.xlsx");
		  wb.write(fos);
		  fos.close();
	  }
	  
		
	
}

