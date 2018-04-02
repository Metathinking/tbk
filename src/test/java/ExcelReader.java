import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ExcelReader.java 2017/01/21 09:50
 */
public class ExcelReader {

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("d:/tbk.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            if (sheet != null) {
                int lastRowNum = sheet.getLastRowNum();
                System.out.println("lastRowNum:"+lastRowNum);

//                for (int x = 0; x < 10; x++) {
                    HSSFRow row = sheet.getRow(lastRowNum);
                    if(row!=null){
                        short lastCellNum = row.getLastCellNum();
                        for(int y=0;y<lastCellNum;y++){
                            HSSFCell cell = row.getCell(y);
                            String stringCellValue = cell.getStringCellValue();
                            System.out.print(y+":");
                            System.out.println(stringCellValue);
                        }
                    }
//                    System.out.println();

//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}