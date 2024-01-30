package med.api.Medico;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.api.Endereco.Endereco;
import jakarta.persistence.*;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter //Criar Getters and Setters
@NoArgsConstructor //Construtor Default obrigatorio em JPA
@AllArgsConstructor //Ter um construtor que recebe todos os campos
@EqualsAndHashCode(of = "id") //Gerar Equals e HaschCode em cima do Id nao em cima de todos atributos
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded //fica numa classe separada mas no banco ele reune os campos TB Medico.
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}