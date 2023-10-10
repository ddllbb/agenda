package com.sb.ln.interfaces;

import com.sb.entities.Contacto;


public interface IContactoServ {

	public Iterable<Contacto> listarContactos();

	public Contacto verContacto(Integer id);

	public void modifContacto(Contacto contacto);
	
	public void eliminarContacto(Integer id);

	void crearContacto(Contacto contacto);

	 
}
