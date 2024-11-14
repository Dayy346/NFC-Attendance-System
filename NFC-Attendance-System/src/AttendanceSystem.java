
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class AttendanceSystem {
    private static final String FILE_NAME = "attendance.xlsx";

    public static void main(String[] args) {
        // Example NFC UID 
        String nfcUid = "1234567890ABCDEF";
        recordAttendance(nfcUid);
    }

    public static void recordAttendance(String nfcUid) {
        try {
            // Create a new workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Attendance");

            // the header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Time");
            headerRow.createCell(1).setCellValue("NFC UID");

            // Create a new row with the attendance data
            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(new Date().toString()); // Record the current time
            row.createCell(1).setCellValue(nfcUid); // Record the NFC UID

            // Write the data to the file
            try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME)) {
                workbook.write(fileOut);
            }

            // Close 
            workbook.close();
            System.out.println("Attendance recorded.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
