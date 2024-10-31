package br.com.fiap.notificacao_acidentes_test_automatizacao.controller;

import br.com.fiap.notificacao_acidentes_test_automatizacao.dto.OcorrenciaCadastroDto;
import br.com.fiap.notificacao_acidentes_test_automatizacao.dto.OcorrenciaExibicaoDto;
import br.com.fiap.notificacao_acidentes_test_automatizacao.model.Ocorrencia;
import br.com.fiap.notificacao_acidentes_test_automatizacao.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService service;

    @PostMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaExibicaoDto salvar(@RequestBody @Valid OcorrenciaCadastroDto ocorrenciaCadastroDto) {
        return service.gravar(ocorrenciaCadastroDto);
    }

    @GetMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.OK)
    public List<OcorrenciaExibicaoDto> listarOcorrencia() {
        return service.listaOcorrencia();
    }

    @PutMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.OK)
    public Ocorrencia atualizar(@RequestBody @Valid OcorrenciaCadastroDto ocorrenciaCadastroDto) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setStatus(ocorrenciaCadastroDto.getStatus());
        ocorrencia.setDataOcorrencia(ocorrenciaCadastroDto.getDataOcorrencia());
        ocorrencia.setVitima(ocorrenciaCadastroDto.getVitima());
        ocorrencia.setEndereco(ocorrenciaCadastroDto.getEndereco());
        ocorrencia.setGravidade(ocorrenciaCadastroDto.getGravidade());
        return service.atualizar(ocorrencia);
    }

    @DeleteMapping("/ocorrencia/{ocorrenciaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long ocorrenciaId) {
        service.excluir(ocorrenciaId);
    }

}
