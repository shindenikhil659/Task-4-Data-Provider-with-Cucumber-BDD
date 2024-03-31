package StepDefination;


import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelDataProvider {

    private static final String FILE_PATH = "/Users/vaishnavi/Downloads/Test_data(1).xlsx";

    public static Object[][] getTestData(String sheetName) {
        Object[][] testData = null;
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            testData = new Object[rowCount][colCount];
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    testData[i - 1][j] = cell.getStringCellValue();
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }
}
