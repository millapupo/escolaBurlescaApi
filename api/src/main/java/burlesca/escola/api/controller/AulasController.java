package burlesca.escola.api.controller;

import burlesca.escola.api.domain.aulas.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aulas")
@SecurityRequirement(name = "bearer-key")
public class AulasController {

    @Autowired
    private AgendaDeAulas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendaAulaDTO dados){

        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoDTO dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
