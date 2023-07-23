package com.info.infoprimeraapp.service.csv.resena.impl;

import com.info.infoprimeraapp.model.ResenaCsvRecord;
import com.info.infoprimeraapp.service.csv.resena.ResenaCsvService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
public class ResenaCsvServiceImpl implements ResenaCsvService {
    @Override
    public List<ResenaCsvRecord> convertCSV(File file) throws FileNotFoundException {
        List<ResenaCsvRecord> resenaCsvRecordList = new CsvToBeanBuilder<ResenaCsvRecord>(new FileReader(file))
                .withType(ResenaCsvRecord.class)
                .build()
                .parse();

        log.info("Convirtiendo CSV a lista de reseñas");
        return resenaCsvRecordList;
    }
}
