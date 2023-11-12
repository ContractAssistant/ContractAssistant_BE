package MtPalgong.legalAssistant.Service;

import MtPalgong.legalAssistant.Entity.Term;
import java.util.List;

public interface TermService {

    public List<String> findAllWord();

    public List<Term> findAll();
}
