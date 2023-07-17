package burlesca.escola.api.controller;

import burlesca.escola.api.domain.professoras.*;
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
@RequestMapping("/professoras")
public class ProfessoraController {

    @Autowired
    private ProfessoraRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProfessoraDTO dados, UriComponentsBuilder uriBuilder){
        repository.save(new Professora(dados));
        var professora = new Professora(dados);
        var uri = uriBuilder.path("/profesoras/{id}").buildAndExpand(professora.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoProfDTO(professora));
    }
    @GetMapping
    public ResponseEntity<Page<ListagemProfDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemProfDTO::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody @Valid AtualizacaoProfDTO dados){
        var professora = repository.getReferenceById(dados.id());
        professora.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetalhamentoProfDTO(professora));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var professora = repository.getReferenceById(id);
        professora.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var professora = repository.getReferenceById(id);
        professora.excluir();
        return ResponseEntity.ok(new DetalhamentoProfDTO(professora));
    }
}
