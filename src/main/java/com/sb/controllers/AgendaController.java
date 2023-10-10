package com.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sb.entities.Contacto;
import com.sb.ln.interfaces.IContactoServ;

@Controller
@RequestMapping(value= {"/","/a"})
public class AgendaController {
	
	@Autowired
	IContactoServ serv;
	
	@GetMapping
	public String listar(Model model) {
		Contacto contacto= new Contacto();
		contacto.setId(0);
		model.addAttribute("unContactoEnBlanco", contacto);
		Iterable<Contacto> contactosLista = serv.listarContactos();
		model.addAttribute("listaParaHtml", contactosLista);
	return "contactos";
	}

	@GetMapping("/{id}")
	public String ver(Model model,@PathVariable Integer id) {
		Contacto contacto = serv.verContacto(id);
		model.addAttribute("unContactoParaHtml",contacto);
		return "contacto";
	}
	
	@GetMapping("/m/{id}")
	public String modificar(Model model,@PathVariable Integer id) {
		Contacto contacto = serv.verContacto(id);
		model.addAttribute("unContactoParaHtml",contacto);
		return "modContacto";
	}
	
	@PostMapping("/m")
	public String modificar(Model model,Contacto contacto) { 
		serv.modifContacto(contacto);
		contacto=serv.verContacto(contacto.getId());
		model.addAttribute("unContactoParaHtml",contacto); 
		return "contacto"; 
	}
	 
	@GetMapping("/d/{id}")
	public String borrar(Model model,@PathVariable Integer id) {
		serv.eliminarContacto(id);
		Contacto contactoBlanco= new Contacto();
		contactoBlanco.setId(0);
		model.addAttribute("unContactoEnBlanco", contactoBlanco);
		Iterable<Contacto> contactosLista = serv.listarContactos();
		model.addAttribute("listaParaHtml", contactosLista);
		return "contactos";
	 }
	
	 @PostMapping("/n") 
	 public String crear(Model model,Contacto contacto) {
		 serv.crearContacto(contacto);  
		 Contacto contactoBlanco= new Contacto();
		 contactoBlanco.setId(0);
		 model.addAttribute("unContactoEnBlanco", contactoBlanco);
		 Iterable<Contacto> contactosLista = serv.listarContactos(); 
		 model.addAttribute("listaParaHtml", contactosLista);
		 return "contactos";
	 }
		 
}
