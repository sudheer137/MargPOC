package com.marg.margpoc.services;

import com.marg.margpoc.model.Outstanding;
import com.marg.margpoc.repository.OutstandingRepository;
import org.apache.poi.ss.usermodel.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class OutstandingServices {
       private final OutstandingRepository outstandingRepository;
       public OutstandingServices(OutstandingRepository outstandingRepository) {
           this.outstandingRepository = outstandingRepository;

       }


    public String save(MultipartFile[] multipartFiles) {

        try {
            for (MultipartFile files : multipartFiles) {
                Outstanding outstanding = new Outstanding();
                InputStream file = files.getInputStream();
                Workbook workbook= WorkbookFactory.create(file);


                int index = workbook.getActiveSheetIndex();

                Sheet sheet = workbook.getSheetAt(index);
                for(int rowindex=1;rowindex<=sheet.getLastRowNum();rowindex++) {
                    Row xRow = sheet.getRow(rowindex);
                    Cell xCell = xRow.getCell(0);
                    outstanding.setRetailerName(xCell.getStringCellValue());
                     xCell = xRow.getCell(1);
                     if(xCell.getCellType()==CellType.STRING)
                     {outstanding.setContactNumber( xCell.getStringCellValue());}
                     else if(xCell.getCellType()==CellType.NUMERIC) {
                         outstanding.setContactNumber(String.valueOf(xCell.getNumericCellValue()));
                     }
                    xCell = xRow.getCell(2);
                    outstanding.setAddress(xCell.getStringCellValue());
                   xCell = xRow.getCell(3);
                    outstanding.setCity(xCell.getStringCellValue());
                    xCell = xRow.getCell(4);
                    outstanding.setState(xCell.getStringCellValue());
                    xCell = xRow.getCell(5);
                    if(xCell.getCellType()==CellType.STRING)
                    {outstanding.setOutstandingBalance( xCell.getStringCellValue());}
                    else if(xCell.getCellType()==CellType.NUMERIC) {
                        outstanding.setOutstandingBalance(String.valueOf(xCell.getNumericCellValue()));
                    }
                    outstandingRepository.save(outstanding);
                }

                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "successfully";
    }
}
