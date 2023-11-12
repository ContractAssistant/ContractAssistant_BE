package MtPalgong.legalAssistant.Service;

import MtPalgong.legalAssistant.Entity.Term;
import MtPalgong.legalAssistant.Repository.TermRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TermServiceImpl implements TermService{

    public final TermRepository termRepository;

    @Override
    public List<String> findAllWord() {
        List<Term> all = termRepository.findAll();
        return all.stream().map(Term::getWord).toList();
    }

    @Override
    public List<Term> findAll() {
        return termRepository.findAll();
    }
}
