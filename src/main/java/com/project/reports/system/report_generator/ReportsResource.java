package com.project.reports.system.report_generator;

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
public class ReportsResource {

    private final ReportsService reportsService;
    private final JasperService jasperService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateReport(
            @RequestParam String reportPath,
            @RequestParam(required = false) Map<String, String> parameters) throws Exception {

        // Convert String parameters to Object (if necessary)
        Map<String, Object> params = new HashMap<>();
        if (parameters != null) {
            params.putAll(parameters);
        }

        // Call the Jasper service to generate the report
        byte[] pdfContent = jasperService.generatePdfReport(reportPath, params);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }

    @GetMapping("route")
    public ResponseEntity<byte[]> getDirectoryReport(@PathVariable Integer Variable)
            throws Exception {

        byte[] pdfContent = reportsService.generateModel(Variable);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }
}
