package burlesca.escola.api.controller;

import burlesca.escola.api.alunas.AlunaRepository;
import burlesca.escola.api.alunas.Aluna;
import burlesca.escola.api.alunas.AlunaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunas")
public class AlunaController {

    @Autowired
    private AlunaRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody AlunaDTO dados){
        repository.save(new Aluna(dados));

    }
}
