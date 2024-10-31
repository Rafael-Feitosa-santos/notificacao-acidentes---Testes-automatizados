package br.com.fiap.notificacao_acidentes_test_automatizacao.service;

import br.com.fiap.notificacao_acidentes_test_automatizacao.dto.OcorrenciaCadastroDto;
import br.com.fiap.notificacao_acidentes_test_automatizacao.dto.OcorrenciaExibicaoDto;
import br.com.fiap.notificacao_acidentes_test_automatizacao.exception.OcorrenciaNaoEncontradaException;
import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Ocorrencia;
import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Status;
import br.com.fiap.notificacao_acidentes_test_automatizacao.repository.OcorrenciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaExibicaoDto gravar(OcorrenciaCadastroDto ocorrenciaCadastroDto) {
        Ocorrencia ocorrencia = new Ocorrencia();
        BeanUtils.copyProperties(ocorrenciaCadastroDto, ocorrencia);
        return new OcorrenciaExibicaoDto(ocorrenciaRepository.save(ocorrencia));

    }

    public List<OcorrenciaExibicaoDto> listaOcorrencia() {
        List<Ocorrencia> ocorrencia = ocorrenciaRepository.findAll();
        return ocorrencia
                .stream()
                .map(OcorrenciaExibicaoDto::new)
                .toList();
    }

    public OcorrenciaExibicaoDto buscarPorNumero(Long ocorrenciaId) {
        Optional<Ocorrencia> entregaOptional = ocorrenciaRepository.findById(ocorrenciaId);

        if (entregaOptional.isPresent()) {
            return new OcorrenciaExibicaoDto(entregaOptional.get());
        } else {
            throw new OcorrenciaNaoEncontradaException("Ocorrencia não encontrada!");
        }
    }


    public Ocorrencia atualizar(Ocorrencia novaOcorrencia) {
        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(novaOcorrencia.getOcorrenciaId());
        if (ocorrenciaOptional.isPresent()) {
            Ocorrencia ocorrenciaExistente = ocorrenciaOptional.get();

            ocorrenciaExistente.setGravidade(novaOcorrencia.getGravidade());
            ocorrenciaExistente.setEndereco(novaOcorrencia.getEndereco());
            ocorrenciaExistente.setVitima(novaOcorrencia.getVitima());
            ocorrenciaExistente.setStatus(novaOcorrencia.getStatus());

            return ocorrenciaRepository.save(ocorrenciaExistente);
        } else {
            throw new RuntimeException("Atualização não efetuada!");
        }
    }


    public void excluir(Long ocorrenciaId) {

        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(ocorrenciaId);

        if (ocorrenciaOptional.isPresent()) {
            ocorrenciaRepository.delete(ocorrenciaOptional.get());
        } else {
            throw new RuntimeException("Ocorrencia não encontrada!");
        }
    }
}
