package com.peliculas.peliculas.service;

import java.util.List;
import java.util.Optional;

import com.peliculas.peliculas.model.Pelicula;

public interface IPeliculaService {
	
	List<Pelicula> findAll();
	Optional<Pelicula> findById(Integer id);
	Pelicula create(Pelicula pelicula);
	Pelicula update(Pelicula pelicula);
	void delete(Integer id);
}
