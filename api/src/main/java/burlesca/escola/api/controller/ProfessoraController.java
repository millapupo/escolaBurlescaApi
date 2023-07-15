package burlesca.escola.api.controller;

import burlesca.escola.api.professoras.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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
    public Page<ListagemProfDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(ListagemProfDTO::new);
    }
    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid AtualizacaoProfDTO dados){
        var professora = repository.getReferenceById(dados.id());
        professora.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var professora = repository.getReferenceById(id);
        professora.excluir();
    }
}
