package com.sb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.entities.Contacto;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Integer>{

}
