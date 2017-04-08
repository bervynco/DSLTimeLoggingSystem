/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsltimeloggingsystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelParser {
    private static User sessionUser = null;
    private static ArrayList<String> employeePages = new ArrayList<>();
    
    public ExcelParser(User user, ArrayList<String> employeePages){
        this.sessionUser = user;
        this.employeePages = employeePages;
    }
    public void parseExcel(File selectedFile) throws FileNotFoundException, IOException, ParseException, ClassNotFoundException, SQLException{
        String excelFilePath = "C:\\Users\\L R E\\Desktop\\attn1.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        
        Iterator<Row> iterator = firstSheet.iterator();
        Row rowHeader = firstSheet.getRow(0);
        int lastCell=firstSheet.getRow(0).getLastCellNum();
        
        String[] array = {"Emp No.", "AC-No.", "Name", "Date", "Clock In", "Clock Out", "ATT_Time"};
        List<Integer> columnIDs = new ArrayList<Integer>();
        Cell c;
        for(int k = 0; k < array.length; k++){
            for (int i = 0; i < lastCell; i++) {
                c = rowHeader.getCell(i);
                String cellData = c.toString();
                if(cellData.equals(array[k])){
                    columnIDs.add(i);
                }
            }
         }

        for (Row row : firstSheet) { // For each Row.
            if(row.getRowNum() == 0){
                continue;
            }
            else{
                    Cell cell1 = row.getCell(columnIDs.get(0)); // Get the Cell at the Index / Colum you want.
                    Cell cell2 = row.getCell(columnIDs.get(1));
                    Cell cell3 = row.getCell(columnIDs.get(2));
                    Cell cell4 = row.getCell(columnIDs.get(3));
                    Cell cell5 = row.getCell(columnIDs.get(4));
                    Cell cell6 = row.getCell(columnIDs.get(5));
                    Cell cell7 = row.getCell(columnIDs.get(6));
                    
                    DB db = new DB();
                    db.insertUserLogFromExcel(Integer.parseInt(cell1.getStringCellValue()),cell4.getStringCellValue(), cell5.getStringCellValue(),
                            cell6.getStringCellValue(), cell7.getStringCellValue() );
            }
            
        }
        
         
        workbook.close();
        inputStream.close();
        
        
    }
}
