package com.jbpm.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    public static void setExcelFile(String excelPath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(excelPath);
        workbook = WorkbookFactory.create(file);
        sheet = workbook.getSheet(sheetName);
    }

    public static String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
