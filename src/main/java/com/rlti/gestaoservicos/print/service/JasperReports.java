package com.rlti.gestaoservicos.print.service;

import com.rlti.gestaoservicos.print.api.OrdemServicoPrintResponse;
import com.rlti.gestaoservicos.print.api.ServicoPrintResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
@Slf4j
public class JasperReports {

    public static String gerarContrachequeBase64(OrdemServicoPrintResponse ordemServico) {
        try {
            InputStream templateStream = JasperReports.class.getResourceAsStream("/templates/ordem_servico.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

            Map<String, Object> parameters = getStringObjectMap(ordemServico);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            byte[] pdfBytes = baos.toByteArray();

            return Base64.getEncoder().encodeToString(pdfBytes);
        } catch (Exception e) {
            return "Erro ao gerar relatório: " + e.getMessage();
        }
    }

    private static Map<String, Object> getStringObjectMap(OrdemServicoPrintResponse ordemServico) {
        Map<String, Object> parameters = new HashMap<>();
        //parametros ordem servico
        parameters.put("protocolo", ordemServico.getProtocolo().toString());
        parameters.put("solicitante", ordemServico.getSetor());
        parameters.put("responsavel", ordemServico.getResponsavel());
        parameters.put("diagnostico", ordemServico.getDiagnostico());
        parameters.put("dataSolicitacao", ordemServico.getDataInicial());
        parameters.put("dataAtendimento", ordemServico.getDataFinal());
        parameters.put("dataEntrega", ordemServico.getDataEntrega());

        parameters.put("tecnicoResponsavel", ordemServico.getSuportes().stream()
                .map(SuporteResponse::getNome)
                .reduce((a, b) -> a + ", " + b)
                .orElse(""));

        //servicos
        List<ServicoPrintResponse> descontosArray = ordemServico.getServicos();
        JRBeanCollectionDataSource servicosDataSet = new JRBeanCollectionDataSource(descontosArray);
        parameters.put("servicosDataSet", servicosDataSet);

        return parameters;
    }

    public static byte[] gerarContrachequePdf(OrdemServicoPrintResponse ordemServico) {
        try {
            InputStream templateStream = JasperReports.class.getResourceAsStream("/templates/ordem_servico.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
            Map<String, Object> parameters = getStringObjectMap(ordemServico);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            return baos.toByteArray();
        } catch (Exception e) {
            log.error("Error generating payslip PDF", e);
            return new byte[0];
        }
    }
}
