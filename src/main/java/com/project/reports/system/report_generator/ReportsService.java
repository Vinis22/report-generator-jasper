package com.project.reports.system.report_generator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReportsService {

    private final JasperService jasperService;

    public byte[] generateModel(Integer Variable) throws Exception {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("PARAMETER", Variable);


        return jasperService.generatePdfReport(
                ReportPaths.getDirectoryReport(),
                parameters
        );
    }

    public byte[] gerarEventoConsolidado(Long Variable) throws Exception {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("PARAMETER", Variable);

        return jasperService.generatePdfReport(
                ReportPaths.getDirectoryReport(),
                parameters
        );
    }
}
