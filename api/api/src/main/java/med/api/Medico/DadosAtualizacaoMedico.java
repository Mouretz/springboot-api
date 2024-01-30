package med.api.Medico;

import med.api.Endereco.DadosEndereco;

public record DadosAtualizacaoMedico(Long id, String nome, String telefone, DadosEndereco endereco) {

}
