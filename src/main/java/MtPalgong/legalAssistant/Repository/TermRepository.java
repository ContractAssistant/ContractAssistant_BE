package MtPalgong.legalAssistant.Repository;

import MtPalgong.legalAssistant.Entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {

}
