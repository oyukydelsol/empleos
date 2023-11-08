package net.itinajero.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.model.Categoria;
import net.itinajero.model.Usuario;
import net.itinajero.model.Vacante;
import net.itinajero.service.IUsuariosService;
import net.itinajero.service.db.UsuariosServiceJpa;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuariosService serviceUsuario;
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Usuario> lista = serviceUsuario.buscarTodos();
		model.addAttribute("usuarios", lista);
    	
    	return "usuarios/listUsuarios";
	}
    
    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
		
    	// Ejercicio.
    	System.out.println("Borrando usuario con id: "+idUsuario);
		serviceUsuario.eliminar(idUsuario);
		attributes.addFlashAttribute("msg","El usuario fue eliminado!");
    	
		return "redirect:/usuarios/index";
	}
  }
