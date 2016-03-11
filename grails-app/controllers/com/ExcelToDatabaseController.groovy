package com

class ExcelToDatabaseController {

    def excelToDatabaseService

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [personInstanceList: Person.list(params), personInstanceTotal: Person.count()]
    }

    def upload() {
    }

    def doUpload() {
        def file = request.getFile('file')
        Boolean excelDataPersistenceStatus  =  excelToDatabaseService.excelDataPersistence(file)
        if (excelDataPersistenceStatus)
            redirect (action:'list')
        else
            render "$file persistence operation has failed "
    }

}
