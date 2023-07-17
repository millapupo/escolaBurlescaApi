package burlesca.escola.api.controller;

import burlesca.escola.api.domain.alunas.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/alunas")
public class AlunaController {

    @Autowired
    private AlunaRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody AlunaDTO dados, UriComponentsBuilder uriBuilder) {
        repository.save(new Aluna(dados));
        var aluna = new Aluna(dados);
        var uri = uriBuilder.path("/alunas/{id}").buildAndExpand(aluna.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoAlunDTO(aluna));
    }
    @GetMapping
    public ResponseEntity<Page<ListagemAlunDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page =  repository.findAllByAtivoTrue(paginacao).map(ListagemAlunDTO::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoAlunDTO dados) {
        var aluna = repository.getReferenceById(dados.id());
        aluna.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetalhamentoAlunDTO(aluna));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var aluna = repository.getReferenceById(id);
        aluna.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var aluna = repository.getReferenceById(id);
        aluna.excluir();
        return ResponseEntity.ok(new DetalhamentoAlunDTO(aluna));
    }
}
