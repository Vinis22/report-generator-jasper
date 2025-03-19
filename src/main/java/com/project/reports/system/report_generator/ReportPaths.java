package com.project.reports.system.report_generator;

public class ReportPaths {

    public static String getRaiz() {
        return "classpath:reports/";
    }

    public static String getRaizImage() {
        return getRaiz() + "imagem/";
    }

    public static String getDirectoryReport() {
        return getRaiz() + "report_exemple/exemple.jasper";
    }
}
