package burlesca.escola.api.controller;

import burlesca.escola.api.professoras.ProfessoraDTO;
import burlesca.escola.api.professoras.ProfessoraRepository;
import burlesca.escola.api.professoras.Professora;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professoras")

public class ProfessoraController {

    @Autowired
    private ProfessoraRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ProfessoraDTO dados){
        repository.save(new Professora(dados));
    }
}
