package com.mundogamer.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mundogamer.model.Juego;
import com.mundogamer.service.CategoriaService;
import com.mundogamer.service.JuegoService;
import com.mundogamer.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

	private final JuegoService juegoService;
	private final CategoriaService categoriaService;
	
	@GetMapping("listado")
	public String listarAdmin(Model model) {
	    model.addAttribute("lstJuegos", juegoService.getAllAdmin());
	    return "admin/listado";
	}
	
	@GetMapping("registrar")
	public String Nuevo(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("juego", new Juego());
		return "admin/registrar";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute Juego juego, @RequestParam MultipartFile file, 
	                        RedirectAttributes flash) {
	    
	    if (!file.isEmpty()) {
	        try {
	            String rutaAbsoluta = "uploads/ImgJuegos/";
	            Files.createDirectories(Paths.get(rutaAbsoluta));

	            File carpeta = new File(rutaAbsoluta);
	            File[] archivos = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
	            
	            int siguienteNumero = 1;
	            if (archivos != null && archivos.length > 0) {
	                for (File f : archivos) {
	                    try {
	                        String nombreSinExtension = f.getName().replace(".jpg", "");
	                        int numeroActual = Integer.parseInt(nombreSinExtension);
	                        if (numeroActual >= siguienteNumero) {
	                            siguienteNumero = numeroActual + 1;
	                        }
	                    } catch (NumberFormatException e) {
	                    }
	                }
	            }

	            String nuevoNombre = String.format("%05d", siguienteNumero) + ".jpg";
	            Path path = Paths.get(rutaAbsoluta + nuevoNombre);
	            Files.write(path, file.getBytes());
	            juego.setImagen(nuevoNombre);
	            
	        } catch (IOException | NumberFormatException e) {
	            e.printStackTrace();
	            flash.addFlashAttribute("Alert", Alert.sweetAlertError("Error al procesar la imagen"));
	            return "redirect:/admin/registrar";
	        }
	    }

	    var response = juegoService.create(juego);
	    flash.addFlashAttribute("Alert", Alert.sweetToast(response.mensaje(), "success", 5000));
	    return "redirect:/admin/listado";
	}
	
	@GetMapping("modificar/{id}")
	public String modificar(@PathVariable Integer id, Model model) {
	    model.addAttribute("categorias", categoriaService.getAll());
	    model.addAttribute("juego", juegoService.getById(id));
	    return "admin/modificar";
	}
	
	@PostMapping("modificar")
	public String guardarModificacion(@ModelAttribute Juego juego, 
	                                  @RequestParam(value = "file", required = false) MultipartFile file, 
	                                  Model model, RedirectAttributes flash) {
	    
	    if (file != null && !file.isEmpty()) {
	        try {
	            String rutaAbsoluta = "uploads/ImgJuegos/";
	            Files.write(Paths.get(rutaAbsoluta + juego.getImagen()), file.getBytes());
	        } catch (IOException e) {
	            model.addAttribute("Alert", Alert.sweetAlertError("Error al actualizar la imagen"));
	            return "admin/modificar";
	        }
	    }
	    var response = juegoService.create(juego);
	    if (!response.success()) {
	        model.addAttribute("categorias", categoriaService.getAll());
	        model.addAttribute("juego", juego);
	        model.addAttribute("Alert", Alert.sweetAlertError(response.mensaje()));
	        return "admin/modificar";
	    }

	    flash.addFlashAttribute("Alert", Alert.sweetToast(response.mensaje(), "success", 5000));
	    return "redirect:/admin/listado";
	}
}
