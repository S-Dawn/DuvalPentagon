package com.duval.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.duval.components.Fault;

public class DSController {

	String fileURL;

	public DSController(String fileURL) {
		super();
		this.fileURL = fileURL;
	}

	public List<DSData> readDS() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream(fileURL);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		Iterator cells;

		rows.next();

		List<DSData> list = new ArrayList<DSData>();
		DSData obj = null;

		while (rows.hasNext()) {

			obj = new DSData();

			row = (XSSFRow) rows.next();
			cells = row.cellIterator();
			
			cell = (XSSFCell) cells.next();
			obj.setFault(cell.getStringCellValue());


			cell = (XSSFCell) cells.next();
			obj.setH2(cell.getNumericCellValue());
			
			cell = (XSSFCell) cells.next();
			obj.setC2H6(cell.getNumericCellValue());

			cell = (XSSFCell) cells.next();
			obj.setCH4(cell.getNumericCellValue());

			cell = (XSSFCell) cells.next();
			obj.setC2H4(cell.getNumericCellValue());

			cell = (XSSFCell) cells.next();
			obj.setC2H2(cell.getNumericCellValue());
			
			list.add(obj);
			
		}
		
		return list;

	}

}
