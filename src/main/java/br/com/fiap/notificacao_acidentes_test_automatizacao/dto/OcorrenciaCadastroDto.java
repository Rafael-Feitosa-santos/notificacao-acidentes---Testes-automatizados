package br.com.fiap.notificacao_acidentes_test_automatizacao.dto;

import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OcorrenciaCadastroDto {

    private Long ocorrenciaId;

    private LocalDate dataOcorrencia;

    @NotBlank(message = "Gravidade do Acidente é obrigatório!")
    private String gravidade;

    @NotBlank(message = "Endereço é obrigatório!")
    private String endereco;

    @NotBlank(message = "É obrigatório informa se possui vítima!")
    private String vitima;

    private Status status;
}
