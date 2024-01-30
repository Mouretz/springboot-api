package med.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.api.Endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")//De 4 a 6 digitos crm deve ter...
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotBlank
        String telefone,
        @NotNull @Valid //Valid serve para validar tbm outro DTO que recebera Anotacoes
        DadosEndereco endereco) {
}
