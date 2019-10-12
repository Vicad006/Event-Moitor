package com.vicad.loader;


import com.vicad.model.Department;
import com.vicad.repository.DepartmentRepo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



// @Service
public class DataLoader {


    @Autowired
    private DepartmentRepo departmentRepo;

    public DataLoader() {

    }

    private static final String SAMPLE_XLSX_FILE_PATH = "/home/oluwaseun/Documents/eventmgt.xlsx";



    public void loadExcel() {

            Workbook workbook = null;

        try{
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        }catch (Exception e){ }


         /*

           ==================================================================
           Iterating over all the rows and columns in a Sheet (Multiple ways)
           ==================================================================
        */

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

        Iterator<Row> rowIterator = sheet.rowIterator();


        List<String> tableHead = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);

                tableHead.add(cellValue);

            }

            System.out.println(tableHead);

            Department department = new Department(tableHead.get(0), tableHead.get(2), tableHead.get(1));
            departmentRepo.save(department);

            tableHead = new ArrayList<>();

            System.out.println();
        }


        // Closing the workbookq

        try{
            workbook.close();

        }catch (Exception e){ }
    }


}
