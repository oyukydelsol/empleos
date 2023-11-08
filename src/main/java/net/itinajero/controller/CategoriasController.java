package net.itinajero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.model.Categoria;
import net.itinajero.model.Vacante;
import net.itinajero.service.ICategoriasService;
import net.itinajero.service.IVacantesService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	@Autowired
	@Qualifier("categoriasServiceJpa")
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria>categorias=serviceCategorias.buscarTodas();
		model.addAttribute("categorias",categorias);
    serviceCategorias.buscarTodas();
	return "categorias/listCategorias";
	}
	// @GetMapping("/create")
	@GetMapping("/create")
	public String crear(Categoria categoria, Model model) {
	return "categorias/formCategoria";
	}
	// @PostMapping("/save")
	@PostMapping("/save")
	public String guardar(Categoria categoria,  BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
				}
			return "categorias/formCategoria";
			}
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro guardado");
		System.out.println("Categoria: "+categoria );
		return "redirect:/categorias/index"; 
	}
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idVacante,RedirectAttributes attributes) {
		System.out.println("Borrando vacante con id: "+idVacante);
		serviceCategorias.eliminar(idVacante);
		attributes.addFlashAttribute("msg","La categoria fue eliminada!");
		return "redirect:/categorias/index";
	}
	@GetMapping("/edit/{id}") 
	public String editar(@PathVariable("id") int idCategoria, Model model) {
	    Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
	    model.addAttribute("categoria", categoria); // Nota el cambio de "vacante" a "categoria"
	    return "categorias/formCategoria";
	}
}
	

