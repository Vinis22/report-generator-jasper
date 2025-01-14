package com.projeto.relatorio.sistema.gerador_relatorio;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class RelatorioController {

    private final RelatorioService relatorioService;
    private final JasperService jasperService;

    @GetMapping("demonstrativo-estagiarios/{folhaPeriodo}")
    public ResponseEntity<byte[]> getDemonstrativoEstagiarios(@PathVariable Integer folhaPeriodo)
            throws Exception {

        byte[] pdfContent = relatorioService.gerarDemonstrativoEstagiarios(folhaPeriodo);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }

    @GetMapping("evento-consolidado/{folhaId}/{periodoInicio}/{periodoFim}")
    public ResponseEntity<byte[]> getEventoConsolidado(@PathVariable Long folhaId,
                                                       @PathVariable Integer periodoInicio,
                                                       @PathVariable Integer periodoFim
    )
            throws Exception {

        byte[] pdfContent = relatorioService.gerarEventoConsolidado(folhaId, periodoInicio, periodoFim);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }

    // Novo endpoint para geração dinâmica
    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateReport(
            @RequestParam String reportPath,
            @RequestParam(required = false) Map<String, String> parameters) throws Exception {

        // Converter os parâmetros de String para Object (se necessário)
        Map<String, Object> params = new HashMap<>();
        if (parameters != null) {
            params.putAll(parameters);
        }

        // Chamar o serviço Jasper para gerar o relatório
        byte[] pdfContent = jasperService.generatePdfReport(reportPath, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }

}
