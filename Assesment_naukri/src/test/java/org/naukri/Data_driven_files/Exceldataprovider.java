package org.naukri.Data_driven_files;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider
{
	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public Exceldataprovider (String Datasheet) throws Exception
    {
        fis = new FileInputStream(Datasheet);
        workbook = new XSSFWorkbook(fis);
        
        fis.close();
    }
 
   // @SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName,int rowNum,int colNum)
    {
        try
        {
            sheet = workbook.getSheet(sheetName);
            
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
            
            if(cell.getCellType() == CellType.STRING)
            	
                return cell.getStringCellValue();
            else if(cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
            {
            	
                String cellValue  = String.valueOf(cell.getNumericCellValue());
                System.out.println(cellValue);
                
                if (HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                System.out.println(cellValue);
                return cellValue;
            }else if(cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
        }
    }

	public int getRowCount(String sheetName1)
	{
		// TODO Auto-generated method stub
	       
		   int rowNums = workbook.getSheet(sheetName1).getLastRowNum();
                rowNums++;
		   System.out.println("Total Number of rows in the excel is : "+rowNums);
		   return rowNums;
	}



}
