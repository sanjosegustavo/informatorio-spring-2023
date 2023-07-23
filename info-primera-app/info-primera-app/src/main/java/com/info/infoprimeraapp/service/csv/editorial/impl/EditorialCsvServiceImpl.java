package com.info.infoprimeraapp.service.csv.editorial.impl;

import com.info.infoprimeraapp.model.EditorialCsvRecord;
import com.info.infoprimeraapp.service.csv.editorial.EditorialCsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


@Service
@Slf4j
public class EditorialCsvServiceImpl implements EditorialCsvService {
    @Override
    public List<EditorialCsvRecord> convertCsv(File file) throws FileNotFoundException {
        List<EditorialCsvRecord> editorialCsvRecordList = new CsvToBeanBuilder<EditorialCsvRecord>(new FileReader(file))
                .withType(EditorialCsvRecord.class)
                .build()
                .parse();

        log.info("Convirtiendo CSV a lista de editoriales.");
        return editorialCsvRecordList;
    }
}
