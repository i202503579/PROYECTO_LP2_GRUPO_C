package com.mundogamer.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mundogamer.service.DetalleService;
import com.mundogamer.service.ReporteService;
import com.mundogamer.service.VentaService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class ReporteController {
	
	private final VentaService ventaService;
	private final DetalleService detalleService;
	private final ReporteService reporteService;
	
	@GetMapping("lista-ventas")
    public String listarVentas(Model model) {
        model.addAttribute("lstVentas", ventaService.getAllVentas());
        return "admin/lista-ventas";
    }
	
	@GetMapping("detalle-venta/{id}")
    public String verDetalle(@PathVariable String id, Model model) {
        model.addAttribute("detalles", detalleService.listarPorVenta(id));
        return "admin/detalle-venta";
    }
	
	@GetMapping("boleta")
    public void boleta(@RequestParam String numBol, HttpServletResponse response) throws Exception {
        String reportPath = "/reporte/boleta.jrxml";

        Map<String, Object> params = new HashMap<>();
        params.put("pNumBoleta", numBol);
        
        JasperPrint jasperPrint = reporteService.getJasperPrint(params, reportPath);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", String.format("inline; filename=boleta-%s.pdf", numBol));

        OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
