/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsltimeloggingsystem;

import static com.itextpdf.text.Annotation.FILE;
import java.util.Date;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author L R E
 */
public class GenerateReport {
//    private static String FILE = "C:/PDF/.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                    Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                    Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                    Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                    Font.BOLD);
    public void generateReport(String startDate, String endDate, String reportType, List<User> users) throws ClassNotFoundException, ParseException, SQLException{
//        System.out.println("SIZE:" + users.size());
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:/PDF/" + reportType + ".pdf"));
            document.open();
            addTitlePage(document);
            
            
            if(reportType.equals("Payroll")){
                addContentPayroll(document, users, reportType);
            }
            else if(reportType.equals("Attendance")){
                addContentAttendance(document, users, reportType, startDate, endDate);
            }
            else{

            }  
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    private static void addTitlePage(Document document)
                    throws DocumentException {
            Paragraph preface = new Paragraph();
            // We add one empty line
            addEmptyLine(preface, 1);
            // Lets write a big header
            preface.add(new Paragraph("DSL", catFont));

            addEmptyLine(preface, 1);
            // Will create: Report generated by: _name, _date
            preface.add(new Paragraph(
                            "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            smallBold));

            document.add(preface);
            // Start a new page
            document.newPage();
    }

    private static void addContentAttendance(Document document, List<User> user, String reportType, String startDate, String endDate) throws DocumentException, ClassNotFoundException, SQLException, ParseException {  
        PdfPTable tableAttendance = new PdfPTable(3);
        PdfPCell c1 = new PdfPCell(new Phrase("Date Log"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableAttendance.addCell(c1);

        c1 = new PdfPCell(new Phrase("Time In"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableAttendance.addCell(c1);

        c1 = new PdfPCell(new Phrase("Time out"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableAttendance.addCell(c1);
        tableAttendance.setHeaderRows(1);
        
        PdfPTable tableAbsence = new PdfPTable(2);
        PdfPCell c2 = new PdfPCell(new Phrase("Absence Date"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableAbsence.addCell(c2);

        c2 = new PdfPCell(new Phrase("Reason"));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableAbsence.addCell(c2);
        tableAbsence.setHeaderRows(1);
        
        Anchor anchor = new Anchor(reportType, catFont);
        anchor.setName("reportType");
        
        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        Section subCatPart = null;
        Paragraph subPara = null;
        catPart.add( Chunk.NEWLINE );
        for(int i = 0; i < user.size(); i++){
            List<Attendance> attendance = new ArrayList<>(); 
            List<Absence> absence = new ArrayList<>();
            String fullName = user.get(i).getFirstName() + ' ' + user.get(i).getLastName();
            subPara = new Paragraph(fullName, subFont);
            addEmptyLine(subPara, 1);
            subCatPart = catPart.addSection(subPara);
            Paragraph headerOne = new Paragraph();
            headerOne.setAlignment(Element.ALIGN_CENTER);

            headerOne.add(new Paragraph("Attendance", subFont));
            Paragraph headerTwo = new Paragraph();
            headerTwo.setAlignment(Element.ALIGN_CENTER);

            headerTwo.add(new Paragraph("Absence", subFont));
            
            
            attendance = DB.getReportAttendance(startDate, endDate, user.get(i).getEmployeeID());
            absence = DB.getAbsentDate(startDate, endDate, user.get(i).getEmployeeID());
            
            if(attendance.size() > 0){
                subCatPart.add( Chunk.NEWLINE );
                subCatPart.add(headerOne);
                subCatPart.add( Chunk.NEWLINE );
                for(int k = 0; k < attendance.size(); k++){
                    tableAttendance.addCell(attendance.get(k).getLogDate().toString());
                    tableAttendance.addCell(attendance.get(k).getTimeInDate().toString());
                    tableAttendance.addCell(attendance.get(k).getTimeOutDate().toString());
                }
                subCatPart.add(tableAttendance);
            }
            if(absence.size() > 0){
                subCatPart.add( Chunk.NEWLINE );
                subCatPart.add(headerTwo);
                subCatPart.add( Chunk.NEWLINE );
                for(int k =0; k < absence.size(); k++){
                    tableAbsence.addCell(absence.get(k).getAbsenceDate().toString());
                    tableAbsence.addCell(absence.get(k).getReason().toString());
                }
                subCatPart.add(tableAbsence);
            }
            subCatPart.add( Chunk.NEWLINE );
        }
        addEmptyLine(subPara, 5);
        // add a table
        document.add(catPart);


    }
    private static void addContentPayroll(Document document, List<User> user, String reportType) throws DocumentException {
            
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
            for (int i = 0; i < number; i++) {
                    paragraph.add(new Paragraph(" "));
            }
    }
}
