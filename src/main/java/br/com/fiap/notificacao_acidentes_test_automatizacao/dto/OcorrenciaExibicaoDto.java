package br.com.fiap.notificacao_acidentes_test_automatizacao.dto;

import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Ocorrencia;
import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Status;

import java.time.LocalDate;

public record OcorrenciaExibicaoDto(

        Long ocorrenciaId,
        LocalDate dataOcorrencia,
        String gravidade,
        String endereco,
        String vitima,
        Status status
) {
    public OcorrenciaExibicaoDto(Ocorrencia ocorrencia) {
        this(
                ocorrencia.getOcorrenciaId(),
                ocorrencia.getDataOcorrencia(),
                ocorrencia.getGravidade(),
                ocorrencia.getEndereco(),
                ocorrencia.getVitima(),
                ocorrencia.getStatus()
        );
    }

}
