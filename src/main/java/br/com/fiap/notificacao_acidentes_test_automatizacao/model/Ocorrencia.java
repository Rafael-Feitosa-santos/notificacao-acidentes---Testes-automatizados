package br.com.fiap.notificacao_acidentes_test_automatizacao.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_OCORRENCIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Ocorrencia {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_TBL_OCORRENCIA"
    )
    @SequenceGenerator(
            name = "SQ_TBL_OCORRENCIA",
            sequenceName = "SQ_TBL_OCORRENCIA",
            allocationSize = 1
    )
    private Long ocorrenciaId;

    @Column(name = "DT_OCORRENCIA")
    private LocalDate dataOcorrencia;

    private String gravidade;

    @Column(name = "DS_ENDERECO")
    private String endereco;

    private String vitima;

    @Enumerated(EnumType.STRING)
    private Status status;

}
