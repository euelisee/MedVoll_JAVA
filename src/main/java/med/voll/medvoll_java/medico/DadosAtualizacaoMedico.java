package med.voll.medvoll_java.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.medvoll_java.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}