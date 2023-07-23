package com.info.infoprimeraapp.service.csv.resena;

import com.info.infoprimeraapp.model.ResenaCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ResenaCsvService {

    List<ResenaCsvRecord> convertCSV(File file) throws FileNotFoundException;
}
