package burlesca.escola.api.controller;

import burlesca.escola.api.alunas.*;
import burlesca.escola.api.professoras.ListagemProfDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunas")
public class AlunaController {

    @Autowired
    private AlunaRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody AlunaDTO dados) {
        repository.save(new Aluna(dados));
    }
    @GetMapping
    public Page<ListagemAlunDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListagemAlunDTO::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizacaoAlunDTO dados) {
        var aluna = repository.getReferenceById(dados.id());
        aluna.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var aluna = repository.getReferenceById(id);
        aluna.excluir();
    }
}
