package med.voll.medvoll_java.paciente;

import jakarta.validation.Valid;
import med.voll.medvoll_java.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}