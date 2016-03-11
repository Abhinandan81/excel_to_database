package com

import grails.transaction.Transactional
import jxl.DateCell
import jxl.LabelCell
import jxl.NumberCell
import jxl.Sheet
import jxl.Workbook

@Transactional
class ExcelToDatabaseService {

    private final static int COLUMN_LAST_NAME = 0
    private final static int COLUMN_FIRST_NAME = 1
    private final static int COLUMN_DATE_OF_BIRTH = 2
    private final static int COLUMN_NUMBER_OF_CHILDREN = 3

    Boolean excelDataPersistence(def file){
        try {
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet(0);

            // skip first row (row 0) by starting from 1
            for (int row = 1; row < sheet.getRows(); row++) {
                LabelCell lastName = sheet.getCell(COLUMN_LAST_NAME, row)
                LabelCell firstName = sheet.getCell(COLUMN_FIRST_NAME, row)
                DateCell dateOfBirth = sheet.getCell(COLUMN_DATE_OF_BIRTH, row)
                NumberCell numberOfChildren = sheet.getCell(COLUMN_NUMBER_OF_CHILDREN, row)

                new Person(lastName: lastName.string, firstName: firstName.string,
                        dateOfBirth: dateOfBirth.date, numberOfChildren: numberOfChildren.value).save()

            }
            return true
        }catch (Exception e){
            return false
        }
    }
}
