package com.projeto.relatorio.sistema.gerador_relatorio;

import java.util.Map;

public class ReportRequest {
    private String reportPath;
    private Map<String, Object> parameters;

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
