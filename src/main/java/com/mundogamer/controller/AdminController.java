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

import com.mundogamer.model.Categoria;
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
	
	@GetMapping("lista-juegos")
	public String listarJuego(Model model) {
	    model.addAttribute("lstJuegos", juegoService.getAllAdmin());
	    return "admin/lista-juegos";
	}
	
	@GetMapping("registrar-juego")
	public String NuevoJuego(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("juego", new Juego());
		return "admin/registrar-juego";
	}
	
	@PostMapping("registrar-juego")
	public String registrarJuego(@ModelAttribute Juego juego, @RequestParam MultipartFile file, 
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
	            return "redirect:/admin/registrar-juego";
	        }
	    }

	    var response = juegoService.create(juego);
	    flash.addFlashAttribute("Alert", Alert.sweetToast(response.mensaje(), "success", 5000));
	    return "redirect:/admin/lista-juegos";
	}
	
	@GetMapping("modificar-juego/{id}")
	public String modificarJuego(@PathVariable Integer id, Model model) {
	    model.addAttribute("categorias", categoriaService.getAll());
	    model.addAttribute("juego", juegoService.getById(id));
	    return "admin/modificar-juego";
	}
	
	@PostMapping("modificar-juego")
	public String guardarModificacion(@ModelAttribute Juego juego, 
	                                  @RequestParam(value = "file", required = false) MultipartFile file, 
	                                  Model model, RedirectAttributes flash) {
	    
	    if (file != null && !file.isEmpty()) {
	        try {
	            String rutaAbsoluta = "uploads/ImgJuegos/";
	            Files.write(Paths.get(rutaAbsoluta + juego.getImagen()), file.getBytes());
	        } catch (IOException e) {
	            model.addAttribute("Alert", Alert.sweetAlertError("Error al actualizar la imagen"));
	            return "admin/modificar-juego";
	        }
	    }
	    var response = juegoService.create(juego);
	    if (!response.success()) {
	        model.addAttribute("categorias", categoriaService.getAll());
	        model.addAttribute("juego", juego);
	        model.addAttribute("Alert", Alert.sweetAlertError(response.mensaje()));
	        return "admin/modificar-juego";
	    }

	    flash.addFlashAttribute("Alert", Alert.sweetToast(response.mensaje(), "success", 5000));
	    return "redirect:/admin/lista-juegos";
	}
	
	@GetMapping("lista-categorias")
	public String listarCategoria(Model model) {
	    model.addAttribute("lstCategoria", categoriaService.getAll());
	    return "admin/lista-categorias";
	}
	
	@GetMapping("registrar-categoria")
	public String NuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "admin/registrar-categoria";
	}
	
	@GetMapping("modificar-categoria/{id}")
    public String modificarCategoria(@PathVariable String id , Model model) {	        
	    model.addAttribute("categoria", categoriaService.getOne(id));
        return "admin/modificar-categoria";
    }
	
	@PostMapping("guardar-categoria")
	public String guardar(@ModelAttribute Categoria categoria, Model model, RedirectAttributes flash) {
	    var response = categoriaService.save(categoria);
	    if (!response.success()) {
	        model.addAttribute("categoria", categoria);
	        model.addAttribute("Alert", Alert.sweetAlertError(response.mensaje()));
	        return "admin/registrar-categoria";
	    }
	    var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
	    flash.addFlashAttribute("Alert", toast);
	    return "redirect:/admin/lista-categorias";
	}
	
	@GetMapping("mensaje")
	public String listarMensaje(Model model) {
	    
	    return "admin/mensaje";
	}
	
	@GetMapping("lista-usuarios")
	public String listarUsuario(Model model) {
	    
	    return "admin/lista-usuarios";
	}
	
	@GetMapping("modificar-usuario")
	public String modificarUsuario(Model model) {
	    
	    return "admin/modificar-usuario";
	}
	
	
}
