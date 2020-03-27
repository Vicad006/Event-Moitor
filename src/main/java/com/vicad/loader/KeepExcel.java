package com.vicad.loader;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.Iterator;

public class KeepExcel {


    public static final String SAMPLE_XLSX_FILE_PATH = "/home/oluwaseun/Documents/eventmgt.xlsx";


    public void loadExcel() {

        Workbook workbook = null;

        try{

            workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        }catch (Exception e){ }

        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");



        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        Sheet sheet = workbook.getSheetAt(0);


        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();


            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }



        try{
            workbook.close();

        }catch (Exception e){ }
    }


}
