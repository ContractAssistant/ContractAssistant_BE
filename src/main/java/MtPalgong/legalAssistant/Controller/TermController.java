package MtPalgong.legalAssistant.Controller;

import MtPalgong.legalAssistant.Entity.Term;
import MtPalgong.legalAssistant.Service.TermService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/term")
public class TermController {

    public final TermService termService;

    @GetMapping("/allWard")
    public List<String> findAllWord(){
        return termService.findAllWord();
    }

    @GetMapping("/all")
    public List<Term> findAll(){
        return termService.findAll();
    }
}
