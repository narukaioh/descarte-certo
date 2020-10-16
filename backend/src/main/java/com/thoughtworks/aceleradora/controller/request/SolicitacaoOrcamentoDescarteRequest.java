package com.thoughtworks.aceleradora.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoOrcamentoDescarteRequest {
    private SolicitanteRequest solicitante;
    private EnderecoResidoRequest endereco;
}
