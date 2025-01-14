package com.projeto.relatorio.sistema.gerador_relatorio;

public class ReportPaths {

    public static String getRaiz() {
        return "classpath:relatorios/";
    }

    public static String getDemonstrativoMainReport() {
        return getRaiz() + "folha/demonstrativo_pagamento_estagiarios.jasper";
    }

//    public static String getFichaCadastralSubReports() {
//        return getRaiz() + "vinculo_funcional/ficha_cadastral/";
//    }

    public static String getRaizImagem() {
        return getRaiz() + "imagem/";
    }

    public static String getEventoConsolidadoMainReport() {
        return getRaiz() + "evento_consolidado/evento_consolidado.jasper";
    }
}
