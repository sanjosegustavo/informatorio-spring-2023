package com.info.infoprimeraapp.service.csv.editorial;

import com.info.infoprimeraapp.model.EditorialCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface EditorialCsvService {

    List<EditorialCsvRecord> convertCsv(File file) throws FileNotFoundException;
}
