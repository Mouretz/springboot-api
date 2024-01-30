package med.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.api.Medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // Injecao de Dependencias automaticas
    //Classe que acessa o banco de Dados
    private MedicoRepository repository;
    @PostMapping
    @Transactional//salvar, atualizar excluir com exito.
    //Parametro json do metodo Cadastrar esta vindo do corpo da requisicao.
    //RequestBody - Requisicao vinda do corpo
    //Valid - Para o Bean Validation se integrar ao spring e executar as validacoes em cima dele
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){//@RequestBody pega do corpo da req;
       repository.save(new Medico(dados));
    }

    //Metodo Listar
    @GetMapping
    public Page<DadosListagemMedicos> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        //.MAP - Converter de Medico para DadosListagemMedicos , .to list converte em lista
    }
    //Metodo UPDATE
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());//Acessa o Banco e carrega o medico pelo ID
        medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")//Parametro Dinamico pois esta em {} no metodo
    @Transactional
    //Para capturar o id , basta recebe-lo no metodo excluir
    //PahVariable e uma variavel do caminho da URL
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);//busca medico por ID
        medico.excluir();//Setar Medico boolean para inativo/ false
    }
}
