package com.info.infoprimeraapp.bootstrap;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.model.BookCsvRecord;
import com.info.infoprimeraapp.repository.book.BookRepository;
import com.info.infoprimeraapp.service.csv.book.BookCsvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final BookCsvService bookCsvService;


    @Override
    public void run(String... args) throws Exception {
        log.info("Corriendo BootstrapData");
        loadBookData();
    }

    private void loadBookData() throws FileNotFoundException {
        if (bookRepository.count() <  100){
            File file = ResourceUtils.getFile("classpath:csvdata/book_data.csv");
            List<BookCsvRecord> bookCsvRecordList = bookCsvService.convertCSV(file);

            if (!bookCsvRecordList.isEmpty()){
                log.info("Cargando la base de datos");
                for (BookCsvRecord bookCsvRecord : bookCsvRecordList) {
                    bookRepository.save(
                            Book.builder()
                                    .uuid(UUID.randomUUID())
                                    .isbn(bookCsvRecord.getIsbn())
                                    .title(bookCsvRecord.getTitle())
                                    .author(bookCsvRecord.getAuthor())
                                    .numberPages(Integer.parseInt(bookCsvRecord.getNumberPage()))
                                    .build()
                    );
                }
            }
        }
    }
}
