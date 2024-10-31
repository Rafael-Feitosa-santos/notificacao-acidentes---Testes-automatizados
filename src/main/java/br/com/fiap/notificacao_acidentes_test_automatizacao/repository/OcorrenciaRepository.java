package br.com.fiap.notificacao_acidentes_test_automatizacao.repository;

import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository  extends JpaRepository<Ocorrencia,Long> {
}
