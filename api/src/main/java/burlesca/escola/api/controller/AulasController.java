package burlesca.escola.api.controller;

import burlesca.escola.api.domain.aulas.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aulas")
public class AulasController {

    @Autowired
    private AgendaDeAulas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendaAulaDTO dados){

        //var dto = agenda.agendar(dados);
        //return ResponseEntity.ok(dto);
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalheAulaDTO( null, null, null, null));
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoDTO dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
