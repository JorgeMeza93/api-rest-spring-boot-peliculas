package com.peliculas.peliculas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPelicula;
	@NotBlank(message = "El titulo es un campo obligatorio")
	@NotNull(message = "El titulo es un campo obligatorio")
	@Size(min = 3, max = 70, message = "El nombre debe ser mayor a tres carácteres")
	@Column(name = "titulo", nullable = false, length = 70)
	private String titulo;
	@Size(min = 4, max = 4, message = "Año inválido, revisar")
	@Column(name = "year", nullable = false, length = 4)
	private Integer year;
	@Size(min = 3,  max = 50)
	@Column(name = "pais", nullable = true, length = 40)
	private String pais;
	@NotNull
	@NotBlank(message = "Duración es un campo obligatorio")
	@Column(name = "duracion", nullable = false, length = 4)
	private Integer duracion;
	@NotNull(message = "Director es un campo obligatorio")
	@NotBlank(message = "Director es un campo obligatorio")
	@Size(min = 3, max = 70)
	@Column(name = "director", nullable = false, length = 50)
	private String director;
	@NotNull(message = "reparto es un campo obligatorio")
	@NotBlank(message = "reparto es un campo obligatorio")
	@Column(name="reparto", nullable = false, length = 150)
	private String reparto;
	@Size(min = 10, max = 500)
	@Column(name="sinopsis", nullable = true, length = 500)
	private String sinopsis;
	public Integer getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	
}
