package com.alkemy.disney.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Personaje implements Serializable, Comparable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @OneToOne
    private Foto foto;
    private String nombre;
    private String edad;
    private Double peso;
    private String historia;
    @ManyToOne
    private Pelicula pelicula;
    
    
    @Override
    public int compareTo(Object t) {
        Personaje personaje = (Personaje) t;
        return this.nombre.compareTo(personaje.getNombre());
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public String getHistoria() {
		return historia;
	}


	public void setHistoria(String historia) {
		this.historia = historia;
	}


	public Pelicula getPelicula() {
		return pelicula;
	}


	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
    
}
