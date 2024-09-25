package com.practice.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

public class ExcelFileReaderUtility {

    @DataProvider(name="EmployeeDataExcelFile")
    public Object[][] getEmployeeTestData() {
        File fl = new File("src/test/resources/TestData/DataProviderTestData.xlsx");
        Object[][] obj = null;
        if (fl.exists()) {
            try {
                FileInputStream fr = new FileInputStream(fl);
                XSSFWorkbook workbook = new XSSFWorkbook(fr);
                XSSFSheet sheet = workbook.getSheet("EmpData");
                int rows = sheet.getPhysicalNumberOfRows();
                int col = sheet.getRow(0).getLastCellNum();
                obj = new Object[rows - 1][col];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < col; j++) {
                        obj[i][j] = sheet.getRow(i + 1).getCell(j);
                    }
                    System.out.println(Arrays.toString(obj[i]));
                }
                workbook.close();
                fr.close();
            } catch (Exception e) {
                System.out.println("Excel file not found. Check the file again at location : " + fl.getAbsolutePath());
            }
        }

        return obj;
    }

}
