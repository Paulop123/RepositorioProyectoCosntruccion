package com.example.SpringBootApp.entidad;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.JoinColumn;

@Entity
public class Usuario implements Serializable{

	
	
	//Constructor
	
	public Usuario(Long id) {
		super();
		this.id = id;
	}



	private static final long serialVersionUID = 241703645075977458L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	//Me sirve para generar automaticamente el id en MySQL
	
	private Long id;
	
	@Column 
	private String firstName;
	
	@Column 
	private String lastName;
	
	@Column(unique = true) 
	private String email;
	
	@Column(unique = true) 
	private String username;
	
	@Column
	private String password;
	
	
	//Esta propiedad no va poder ser mapeada por la clase o superclase
	//porque esto es solo para confirmar que la contraseña creada
	//coincide.
	@Transient 
	private String confirmPassword;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	
	
	private Set<Rol> roles;//Con este set obligamos a que no se repita ningun valor


	
	//Getter and setter

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public Set<Rol> getRoles() {
		return roles;
	}



	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}



	//Tostring sobreescrito
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", roles=" + roles + "]";
	}


	
	//hashcode and equals me permite compararar los objetos para saber si son el mismo.

	@Override
	public int hashCode() {
		return Objects.hash(confirmPassword, email, firstName, id, lastName, password, roles, username);
	}



	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Usuario other = (Usuario) obj;
		return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
