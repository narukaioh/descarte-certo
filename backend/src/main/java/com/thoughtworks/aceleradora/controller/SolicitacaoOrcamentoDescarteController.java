package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.controller.request.SolicitacaoOrcamentoDescarteRequest;
import com.thoughtworks.aceleradora.controller.response.MessageResponse;
import com.thoughtworks.aceleradora.controller.response.SolicitacaoOrcamentoDescarteResponse;
import com.thoughtworks.aceleradora.domain.SolicitacaoOrcamentoDescarteService;
import com.thoughtworks.aceleradora.entity.SolicitacaoOrcamentoDescarte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/solicitcaoOrcamentoDescarte")
public class SolicitacaoOrcamentoDescarteController {

    private SolicitacaoOrcamentoDescarteService solicitacaoOrcamentoDescarteService;

    public SolicitacaoOrcamentoDescarteController(SolicitacaoOrcamentoDescarteService solicitacaoOrcamentoDescarteService) {
        this.solicitacaoOrcamentoDescarteService = solicitacaoOrcamentoDescarteService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity create(@RequestBody SolicitacaoOrcamentoDescarteRequest solicitacaoOrcamentoDescarteRequest) {
        SolicitacaoOrcamentoDescarte solicitacao = solicitacaoOrcamentoDescarteService
                .create(solicitacaoOrcamentoDescarteRequest);
        SolicitacaoOrcamentoDescarteResponse response = SolicitacaoOrcamentoDescarteResponse
                .builder()
                .codigoSolicitacao(solicitacao.getId())
                .build();
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<SolicitacaoOrcamentoDescarte> optionalSolicitacao
                = solicitacaoOrcamentoDescarteService.getSolicitacao(id);
        if (optionalSolicitacao.isPresent()) {
            SolicitacaoOrcamentoDescarte solicitacao = optionalSolicitacao.get();
            return new ResponseEntity(solicitacao, HttpStatus.OK);
        } else {
            return new ResponseEntity(MessageResponse
                    .builder().msg("Solicitação de orçamento não encontrado").build(),
                    HttpStatus.NOT_FOUND);
        }
    }
}