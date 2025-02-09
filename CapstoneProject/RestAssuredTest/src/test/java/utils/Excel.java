package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    private static XSSFWorkbook workbook;
    private static List<String> countryList;

    public static String[][] loadExcelTestData() throws FileNotFoundException, IOException {
        workbook = new XSSFWorkbook(new FileInputStream(new File(Config.getProperty("INPUT_FILE_PATH"))));
        countryList = new ArrayList<String>();


        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        for(int i=1;i<=lastRow;i++) {
            countryList.add(sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
        }
        // Convert ArrayList<String> to String[][]
        String[][] stringArray = new String[countryList.size()][1];

        for (int i = 0; i < countryList.size(); i++) {
            stringArray[i][0] = countryList.get(i);
        }
        return stringArray;
    }
}
