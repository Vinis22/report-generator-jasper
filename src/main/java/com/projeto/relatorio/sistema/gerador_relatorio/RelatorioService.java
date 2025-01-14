package com.projeto.relatorio.sistema.gerador_relatorio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class RelatorioService {

    private final JasperService jasperService;

    public byte[] gerarDemonstrativoEstagiarios(Integer folhaPeriodo) throws Exception {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("FOLHA_P", folhaPeriodo);


        return jasperService.generatePdfReport(
                ReportPaths.getDemonstrativoMainReport(),
                parameters
        );
    }

    public byte[] gerarEventoConsolidado(Long folhaId, Integer periodoInicio, Integer periodoFim) throws Exception {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("FOLHA_ID", folhaId);
        parameters.put("PERIODO_INICIO", periodoInicio);
        parameters.put("PERIODO_FIM", periodoFim);


        return jasperService.generatePdfReport(
                ReportPaths.getEventoConsolidadoMainReport(),
                parameters
        );
    }
}
