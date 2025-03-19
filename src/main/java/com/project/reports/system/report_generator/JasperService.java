package com.project.reports.system.report_generator;

import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class JasperService {

    private DataSource dataSource;
    private ResourceLoader resourceLoader;

    @Transactional
    public byte[] generatePdfReport(String mainReportPath, Map<String, Object> parameters) throws Exception {

        Resource mainReportResource = resourceLoader.getResource(mainReportPath);
        JasperReport mainReport = (JasperReport) JRLoader.loadObject(mainReportResource.getInputStream());

        if (parameters == null) {
            parameters = new HashMap<>();
        }

        parameters.put("PARAMETER", ReportPaths.getRaizImage());

        try (Connection connection = dataSource.getConnection()) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, parameters, connection);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            return outputStream.toByteArray();
        }
    }
}
