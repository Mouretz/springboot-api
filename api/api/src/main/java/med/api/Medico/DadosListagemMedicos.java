package med.api.Medico;

//DTO para dados de medicos que devolvem dados da API
//Apenas com os campos que serao devolvidor para o Cliente no Front End
public record DadosListagemMedicos(Long id, String nome, String email,String crm, Especialidade especialidade) {

    //Chamar construtor do record principal Obrigatorio
    //Apartir de um medico ele preenche as inf do construtor do record.
    public DadosListagemMedicos(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
