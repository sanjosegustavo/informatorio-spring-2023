package com.info.infoprimeraapp.service.csv.book.impl;

import com.info.infoprimeraapp.model.BookCsvRecord;
import com.info.infoprimeraapp.service.csv.book.BookCsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
public class BookCsvServiceImpl implements BookCsvService {
    @Override
    public List<BookCsvRecord> convertCSV(File file) throws FileNotFoundException {
        List<BookCsvRecord> bookCsvRecordList = new CsvToBeanBuilder<BookCsvRecord>(new FileReader(file))
                .withType(BookCsvRecord.class)
                .build()
                .parse();

        log.info("Convirtiendo CSV a lista de libros");
        return bookCsvRecordList;
    }
}
