package med.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.Paciente.DadosCadastroPaciente;
import med.api.Paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController //Externaliza a classa para um servico WEB do tipo REST
@RequestMapping("pacientes") //Mapeando requisicao ou endpoint de aplicacao rest
public class PacienteController {

    @Autowired//Injecao de Dependencia,Instancia automatica,atributo sera instanciado no controler
    private PacienteRepository repository;
    @PostMapping//Habilita rota para executar comando
    @Transactional//todas as operações de banco de dados dentro do método serão executadas dentro de uma única transação.
    public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
        System.out.println("dados recebido: " +dados);
    }

}
