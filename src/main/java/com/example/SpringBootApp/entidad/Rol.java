package com.example.SpringBootApp.entidad;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Anotacion

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1054270224331897603L;// Este servira para generar el id
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator= "native")//Metodo que genera el id de 
	                                                                  //forma automatica.
	@GenericGenerator(name= "native", strategy= "native")
	private Long id;
	
	
	@Column
	private String name;
	
	
	@Column
	private String description;


	
	//Getter y setter
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	//hashcode and equals me permite compararar los objetos para saber si son el mismo.

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Rol other = (Rol) obj;
		
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}


	//To string sobreescrito
	@Override
	public String toString() {
		
		return "Rol [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
