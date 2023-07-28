package burlesca.escola.api.domain.aulas;

import burlesca.escola.api.domain.alunas.AlunaRepository;
import burlesca.escola.api.domain.professoras.ProfessoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeAulas {

    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private ProfessoraRepository professoraRepository;
    @Autowired
    private AlunaRepository alunaRepository;

    public void agendar(DadosAgendaAulaDTO dados){
        var professora = professoraRepository.findById(dados.idProfessora()).get();
        var aluna = alunaRepository.findById(dados.idAluna()).get();
        var aula = new Aula(null, professora, aluna, dados.data());
        aulaRepository.save(aula);
    }
}
