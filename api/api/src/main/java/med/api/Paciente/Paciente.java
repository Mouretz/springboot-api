package med.api.Paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.api.Endereco.Endereco;

@Getter//Lombok - Criar gets and sets
@NoArgsConstructor //Criar construtor Default obrigatorio JPA
@AllArgsConstructor //Ter um construtor que recebe todos os campos
@EqualsAndHashCode(of = "id") //Gerar Equals e HaschCode em cima do Id nao em cima de todos atributos
//anotacoes Jakarta para persistencia no Banco - Representacao da tablea e entidade
@Table(name = "pacientes")//especificar o nome e outras propriedades da tabela na qual a entidade será mapeada.
@Entity(name = "Paciente")// definir uma classe como uma entidade que representa uma tabela no banco de dados.
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //identificador único serão gerados pela coluna de auto incremento do banco de dados.
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded //Embutido - Faz de um objeto um componente , neste caso componente de Paciente se reune na TB no BD;
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }
}
