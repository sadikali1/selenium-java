package com.framework;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private XSSFWorkbook wb = null;
	private XSSFSheet ws = null;

	/**
	 * This is constructor
	 * 
	 * @param fileName:     contains file name of sheet
	 * @param relativePath: relative path of project where file is
	 */
	public ExcelUtils(String fileName, String relativePath) {
		try {
			FileInputStream ipstr = new FileInputStream(relativePath + fileName);
			wb = new XSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To retrieve No Of Rows from .xls file's sheets.
	 * 
	 * @param wsName
	 * @return number of row
	 */
	public int retrieveNoOfRows(String wsName) {
		int rows = 0;
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return 0;
		else {
			ws = wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum() + 1;
			for (int i = 0; i < rowCount; i++) {
				XSSFRow row = ws.getRow(i);
				if (row == null)
					break;
				XSSFCell cell = row.getCell(0);
				String value = getCellValue(cell);
				if (value.isEmpty()) {
					break;
				}
				rows++;
			}
		}
		return rows;
	}
	
	
	/**
	 * To retrieve No Of Columns from .xls file's sheets.
	 * 
	 * @param wsName
	 * @return number of column
	 */
	public int retrieveNoOfCols(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		int column = 0;
		if (sheetIndex == -1)
			return 0;
		else {
			ws = wb.getSheetAt(sheetIndex);
			int colCount = ws.getRow(0).getLastCellNum();
			for (int i = 0; i < colCount; i++) {
				XSSFRow row = ws.getRow(0);
				if (row == null)
					break;
				XSSFCell cell = row.getCell(i);
				String value = getCellValue(cell);
				if (!value.isEmpty()) {
					column++;
				}

			}
			return column;
		}
	}

	/**
	 * To retrieve test data from test case data sheets.
	 * 
	 * @param wsName
	 * @return return all list of test data
	 */
	public Object[][] retrieveTestData(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return null;
		else {
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);

			Object data[][] = new Object[rowNum - 1][colNum];

			for (int i = 0; i < rowNum - 1; i++) {
				XSSFRow row = ws.getRow(i + 1);
				for (int j = 0; j < colNum; j++) {
					if (row == null) {
						data[i][j] = "";
					} else {
						XSSFCell cell = row.getCell(j);
						if (cell == null) {
							data[i][j] = "";
						} else {
							// cell.setCellType(Cell.CELL_TYPE_STRING);
							String value = getCellValue(cell);
							data[i][j] = value;
						}
					}
				}
			}
			return data;
		}

	}

	public static String getCellValue(Cell cell) {
		String strResult = "";
		Cell celldata = (Cell) cell;
		try {
			switch (celldata.getCellType()) {
			case BLANK:
				strResult = "";
				break;
			case FORMULA:
				strResult = String.valueOf(cell.getCellFormula());
				break;
			case BOOLEAN:
				strResult = String.valueOf(cell.getBooleanCellValue());
				break;
			case ERROR:
				strResult = String.valueOf(cell.getErrorCellValue());
				break;
			case NUMERIC:
				strResult = String.valueOf(cell.getNumericCellValue());
				if (strResult.endsWith(".0")) {
					strResult = strResult.replace(".0", "");
				}
				break;
			case STRING:
				strResult = cell.getStringCellValue();
				break;
			default:
				strResult = "";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			//System.out.println("The cell is blank");
		}
		return strResult;
	}
	
}
