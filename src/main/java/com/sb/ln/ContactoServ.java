package com.sb.ln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entities.Contacto;
import com.sb.ln.interfaces.IContactoServ;
import com.sb.repositories.ContactoRepository;

@Service
public class ContactoServ implements IContactoServ {
	
	@Autowired
	ContactoRepository repositorio;
	
	public Iterable<Contacto> listarContactos(){
		Iterable<Contacto> libros= repositorio.findAll();
	return libros;
	}

	@Override
	public Contacto verContacto(Integer id) {
		Contacto contacto = repositorio.findById(id).get();
		return contacto;
	}

	@Override
	public void modifContacto(Contacto contacto) {
		repositorio.save(contacto);
	}

	@Override
	public void eliminarContacto(Integer id){
		repositorio.deleteById(id);
	}
	
	@Override
	public void crearContacto(Contacto contacto){
		repositorio.save(contacto);
	}
}
