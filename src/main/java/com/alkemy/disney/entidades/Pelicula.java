package com.alkemy.disney.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pelicula implements Serializable, Comparable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @OneToOne
    private Foto foto;
    private String titulo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;
    @OneToOne
    private Calificacion calificacion;
    @OneToOne
    private Genero genero;
    
    
    
    
    @Override
    public int compareTo(Object t) {
        Pelicula pelicula = (Pelicula) t;
        return this.titulo.compareTo(pelicula.getTitulo());
    }




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public Foto getFoto() {
		return foto;
	}




	public void setFoto(Foto foto) {
		this.foto = foto;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}




	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}




	public Calificacion getCalificacion() {
		return calificacion;
	}




	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}




	public Genero getGenero() {
		return genero;
	}




	public void setGenero(Genero genero) {
		this.genero = genero;
	}
    
}
