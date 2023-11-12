package MtPalgong.legalAssistant.PostConstructor;

import MtPalgong.legalAssistant.Entity.Term;
import MtPalgong.legalAssistant.Repository.TermRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CSVToObj {

    public final TermRepository termRepository;

    @PostConstruct
    public void parseCsv() throws CsvValidationException {

        String csvFilePath = "src/main/resources/term.csv"; // CSV 파일 경로
        List<Term> terms = new ArrayList<>();

        if (termRepository.count() == 0) {
            try {
                CSVReader csvReader = new CSVReader(new FileReader(csvFilePath, Charset.forName("UTF-8")));

                String[] nextRecord;
                csvReader.readNext();
                while ((nextRecord = csvReader.readNext()) != null) {
                    Term temp = new Term(Long.parseLong(nextRecord[0]), nextRecord[1], nextRecord[2]);
                    terms.add(temp);
                }
                termRepository.saveAll(terms);
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
