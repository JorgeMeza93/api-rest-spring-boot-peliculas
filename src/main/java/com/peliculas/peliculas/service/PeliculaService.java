package com.peliculas.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peliculas.peliculas.model.Pelicula;
import com.peliculas.peliculas.repository.IPeliculaRepository;

@Service 
/* Service se encarga de gestionar las operaciones de negocio más importantes de la aplicación y aglutina lllamadas a diferentes repositorios */ 
public class PeliculaService implements IPeliculaService{
	
	@Autowired
	//Para tener acceso a los datos necesitamos una instancia de IPeliculasRepository que nos permita hacer operaciones dentro de la base de datos
	private IPeliculaRepository peliculaRepository;
	
	@Override
	public List<Pelicula> findAll() {
		return peliculaRepository.findAll();
	}

	@Override
	public Optional<Pelicula> findById(Integer id) {
		return peliculaRepository.findById(id);
	}

	@Override
	public Pelicula create(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public void delete(Integer id) {
		peliculaRepository.deleteById(id);
		
	}
	
}
