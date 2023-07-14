package burlesca.escola.api.controller;

import burlesca.escola.api.professoras.ListagemProfDTO;
import burlesca.escola.api.professoras.ProfessoraDTO;
import burlesca.escola.api.professoras.ProfessoraRepository;
import burlesca.escola.api.professoras.Professora;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

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
    @GetMapping
    public Stream<ListagemProfDTO> listar(Pageable paginacao){
        return repository.findAll(paginacao).stream().map(ListagemProfDTO::new);
    }
}
