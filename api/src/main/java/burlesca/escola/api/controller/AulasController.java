package burlesca.escola.api.controller;

import burlesca.escola.api.domain.aulas.AgendaDeAulas;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import burlesca.escola.api.domain.aulas.DadosDetalheAulaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aulas")
public class AulasController {

    @Autowired
    private AgendaDeAulas agenda;

    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendaAulaDTO dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalheAulaDTO( null, null, null, null));

    }

}
