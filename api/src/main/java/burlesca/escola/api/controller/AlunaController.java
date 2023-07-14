package burlesca.escola.api.controller;

import burlesca.escola.api.alunas.AlunaRepository;
import burlesca.escola.api.alunas.Aluna;
import burlesca.escola.api.alunas.AlunaDTO;
import burlesca.escola.api.alunas.ListagemAlunDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/alunas")
public class AlunaController {

    @Autowired
    private AlunaRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody AlunaDTO dados){
        repository.save(new Aluna(dados));
    }
    @GetMapping
    public Stream<ListagemAlunDTO> listar(Pageable paginacao){
        return repository.findAll(paginacao).stream().map(ListagemAlunDTO::new);
    }
}
