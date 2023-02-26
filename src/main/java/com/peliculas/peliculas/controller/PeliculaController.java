package com.peliculas.peliculas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peliculas.peliculas.model.Pelicula;
import com.peliculas.peliculas.service.IPeliculaService;
import com.peliculas.peliculas.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> obtenerPeliculas(){
		return ResponseEntity.ok(peliculaService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> obtenerPorId(@PathVariable("id") Integer idPelicula){
		return peliculaService.findById(idPelicula)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@GetMapping("/saludo")
	public ResponseEntity<String> prueba(){
		String saludo = "Hola Mundo";
		//return new ResponseEntity<>(saludo, HttpStatus.OK);
		return ResponseEntity.ok(saludo);
	}
	@PostMapping("/nuevo")
	public ResponseEntity<Pelicula> crearPelicula(@Valid @RequestBody Pelicula pelicula){
		return new ResponseEntity<>(peliculaService.create(pelicula), HttpStatus.CREATED);
	}
	@PutMapping("/actualizar")
	public ResponseEntity<Pelicula> actualizarPelicula(@Valid @RequestBody Pelicula pelicula){
		return peliculaService.findById(pelicula.getIdPelicula())
				.map( peli -> ResponseEntity.ok(peliculaService.update(pelicula)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	public ResponseEntity<Pelicula> eliminarPelicula(Integer idPelicula){
		return peliculaService.findById(idPelicula)
				.map( peli -> {
					peliculaService.delete(idPelicula);
					return ResponseEntity.ok(peli);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
}
