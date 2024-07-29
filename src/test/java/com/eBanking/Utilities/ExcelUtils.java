package com.eBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream file1;
	public static FileOutputStream file2;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		
		file1=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(file1);
		sheet=workbook.getSheet(xlsheet);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		file1.close();
		return rowCount;
			
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		
		file1=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(file1);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		file1.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile, String xlsheet,int rownum, int cellnum) throws IOException {
		
		 file1=new FileInputStream(xlfile);
		 workbook=new XSSFWorkbook(file1);
		 sheet=workbook.getSheet(xlsheet)	 ;
		 row=sheet.getRow(rownum);
		 cell=row.getCell(cellnum);
		 String data;
		 
		 try {
			data=cell.toString();
		} catch (Exception e) {
			data="";
		}
		 workbook.close();
		 file1.close();
		 return data;	
		
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int cellnum, String data) throws IOException {
		
		
		 file1=new FileInputStream(xlfile);
		 workbook=new XSSFWorkbook(file1);
		 sheet=workbook.getSheet(xlsheet);
		 row=sheet.getRow(rownum);
		
		
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		file2=new FileOutputStream(xlfile);
		workbook.write(file2);
		workbook.close();
		file2.close();
		
	}
	
	public static void fillGreenColor(String xlfile, String xlsheet,int rownum, int cellnum) throws IOException {
		
		file1=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(file1);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		file2=new FileOutputStream(xlfile);
		workbook.write(file2);
		workbook.close();
		file2.close();
		
				
	}
	
	public static void fillRedColor(String xlfile, String xlsheet,int rownum, int cellnum) throws IOException {
		
		file1=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(file1);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		file2=new FileOutputStream(xlfile);
		workbook.write(file2);
		workbook.close();
		file2.close();
		
				
	}
	
	


}
