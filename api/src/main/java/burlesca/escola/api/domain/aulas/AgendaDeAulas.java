package burlesca.escola.api.domain.aulas;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.alunas.AlunaRepository;
import burlesca.escola.api.domain.aulas.validacoes.agendamento.ValidadorAgendamentoDeAula;
import burlesca.escola.api.domain.aulas.validacoes.cancelamento.ValidadorCancelamentoDeAula;
import burlesca.escola.api.domain.professoras.Professora;
import burlesca.escola.api.domain.professoras.ProfessoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeAulas {

    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private ProfessoraRepository professoraRepository;
    @Autowired
    private AlunaRepository alunaRepository;
    @Autowired
    private List<ValidadorAgendamentoDeAula> validador;
    @Autowired
    private List<ValidadorCancelamentoDeAula> validadorCancelamentoDeAulas;


    public DadosDetalheAulaDTO agendar(DadosAgendaAulaDTO dados) {
        if (!alunaRepository.existsById(dados.idAluna())) {
            throw new ValidacaoException("Id da aluna não existe!");
        }
        if (dados.idProfessora() != null && !professoraRepository.existsById(dados.idProfessora())) {
            throw new ValidacaoException("Id da professora não existe!");
        }
        validador.forEach( v -> v.validar(dados));

        var professora = escolherProfessora(dados);
        var aluna = alunaRepository.getReferenceById(dados.idAluna());
        if(professora == null){
            throw new ValidacaoException("Não há professora disponível nesta data!");
        }
        var aula = new Aula(null, professora, aluna, dados.data(), null);
        aulaRepository.save(aula);
        return new DadosDetalheAulaDTO(aula);
    }
    private Professora escolherProfessora(DadosAgendaAulaDTO dados) {
        if (dados.idProfessora() != null) {
            return professoraRepository.getReferenceById(dados.idProfessora());
        }
        if(dados.modalidade() == null){
            throw new ValidacaoException("Modalidade da aula precisa ser informada!");
        }
        return professoraRepository.escolherProfAleatoriaLivreNaData(dados.modalidade(), dados.data());
    }
    public void cancelar(DadosCancelamentoDTO dados) {
        if(!aulaRepository.existsById(dados.idAula())){
            throw new ValidacaoException("Id da aula informada não existe!");
        }
        var aula = aulaRepository.getReferenceById(dados.idAula());
        aula.cancelar(dados.motivosCancelamento());

    }
}



