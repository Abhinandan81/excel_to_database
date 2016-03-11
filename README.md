## Uploading an Excel & Persisting it's Data to Database  ##
> **Note:**
Grails version: 2.4.4, mysql-connector-java:5.1.29

**reference link :**  		

 - 	http://grails.asia/grails-example-upload-excel-data-file-to-database
 

----------
**Adding dependency to the BuildConfig.groovy**

     dependencies {
     // for uploading and persisting excel contents to the database
        runtime 'net.sourceforge.jexcelapi:jxl:2.6.12'      
    }


----------


***Created a new Domain Class "Person" in  package "com" :***

    package com.krixi.excelToDatabase
    
    class Person {
        String lastName
        String firstName
        Date dateOfBirth
        int numberOfChildren
        static constraints = {
        }
    }

This table will be used for storing excel contents.

----------
**Created new controller "ExcelToDatabaseController" under  "com" package**
This controller is having view and action for uploading excel , persisting excel contents and fetching database details. 


----------
**Created new service "ExcelToDatabaseService" under  "com" package**
method "excelDataPersistence" used for parsing and persisting Excel data.


----------
**Sample Excel sheet:**
Sample excel sheet can be found under **sampleExcelFiles** directory


----------
