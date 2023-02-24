package com.peliculas.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peliculas.peliculas.model.Pelicula;
import com.peliculas.peliculas.service.IPeliculaService;
import com.peliculas.peliculas.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> obtenerPeliculas(){
		return ResponseEntity.ok(peliculaService.findAll());
	}
}
