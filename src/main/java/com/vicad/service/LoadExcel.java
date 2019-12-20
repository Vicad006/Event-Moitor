package com.vicad.service;


import com.vicad.model.Department;
import com.vicad.model.Gender;
import com.vicad.model.MaritalStatus;
import com.vicad.model.Members;
import com.vicad.repository.DepartmentRepo;
import com.vicad.repository.GenderRepo;
import com.vicad.repository.MaritalStatusRepo;
import com.vicad.repository.MembersRepo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class LoadExcel {


    private DepartmentRepo departmentRepo;
    private MembersRepo membersRepo;
    private GenderRepo genderRepo;
    private MaritalStatusRepo maritalStatusRepo;

    public LoadExcel(DepartmentRepo departmentRepo, MembersRepo membersRepo, GenderRepo genderRepo, MaritalStatusRepo maritalStatusRepo) {
        this.departmentRepo = departmentRepo;
        this.membersRepo = membersRepo;
        this.genderRepo = genderRepo;
        this.maritalStatusRepo = maritalStatusRepo;
    }

    private static final String SAMPLE_XLSX_FILE_PATH = "/home/oluwaseun/Documents/eventmgt.xlsx";



    public void loadExternalData() {

            Workbook workbook = null;

        try{
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        }catch (Exception e){
            System.out.println(e);
        }


         /*
           ==================================================================
           Iterating over all the rows and columns in a Sheet (Multiple ways)
           ==================================================================
        */



        // Getting the sheet at index zero; Gender data
        Sheet genderSheet = workbook.getSheetAt(0);
        List<List<String>> genderTableRows = this.readData(genderSheet);

        for (List<String> tableRow : genderTableRows){

            String details = tableRow.get(0);

            Gender gender = new Gender(details);
            genderRepo.save(gender);
        }


        // Getting the sheet at index One; Marital Status data

        Sheet maritalStatusSheet = workbook.getSheetAt(1);
        List<List<String>> maritalStatusTableRows = this.readData(maritalStatusSheet);

        for (List<String> tableRow : maritalStatusTableRows){

            String status = tableRow.get(0);

            MaritalStatus maritalStatus = new MaritalStatus(status);

            maritalStatusRepo.save(maritalStatus);
        }



        // Getting the Sheet at index two ; Department data
        Sheet departmentSheet = workbook.getSheetAt(2);
        List<List<String>> departmentTableRows = this.readData(departmentSheet);

        for (List<String> tableRow : departmentTableRows){

            String name = tableRow.get(0);
            String description = tableRow.get(2);
            String deptCode = tableRow.get(1);

            Department department = new Department(name, description, deptCode);
            departmentRepo.save(department);

        }



        // Getting the Sheet at index three ; Member data
        Sheet membersSheet = workbook.getSheetAt(3);
        List<List<String>> membersTableRows = this.readData(membersSheet);

        for (List<String> tableRow : membersTableRows){


            String deptCode = tableRow.get(0);
            String lName = tableRow.get(1);
            String fName = tableRow.get(2);
            String email = tableRow.get(3);
            String phoneNum = tableRow.get(4);
            String address = tableRow.get(5);
            String birthdayString = tableRow.get(6);
            String genderString = tableRow.get(7);
            String postCode = tableRow.get(8);
            String maritalStatusString = tableRow.get(9);


            Department department = departmentRepo.findByDeptCode(deptCode);

            Gender gender = genderRepo.findByDetails(genderString);



            MaritalStatus maritalStatus = maritalStatusRepo.findByStatus(maritalStatusString);


            Date birthday = null;
            try {
                 birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthdayString);
            }catch (ParseException e){ }


            Members members = new Members(lName, fName, email, phoneNum, address, birthday, postCode, department, gender, maritalStatus);


            membersRepo.save(members);
        }



       /* Members members = membersRepo.findByFName("Olorunda");

        System.out.println("Member name is " +members.getfName());

        System.out.println("Department name is " +members.getDepartment().getName());


        System.out.println("Gender is " +members.getGender().getDetails());*/



        // Closing the workbook

        try{
            workbook.close();

        }catch (Exception e){ }
    }



    public List<List<String>> readData(Sheet sheet){


        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");

        Iterator<Row> rowIterator = sheet.rowIterator();

        List<List<String>> tableRows = new ArrayList<>();


        Integer rowCouter = 0;

        while (rowIterator.hasNext()) {

            List<String> tableRow = new ArrayList<>();

            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);

                tableRow.add(cellValue);

            }

            if(rowCouter != 0) {
                tableRows.add(tableRow);
            }

            System.out.println(tableRow);
            System.out.println();


            rowCouter++;

        }


        return tableRows;
    }



}
