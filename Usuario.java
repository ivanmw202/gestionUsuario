package com.gestionUser.models;


import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
//1
@Table (name = "usuario")
@Entity 
public class Usuario {
		//2
		@Column(name = "id")
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ1")
		@SequenceGenerator(sequenceName = "customer_seq1", allocationSize = 1, name = "CUST_SEQ1")
		private Long id;
		//2
		@Column(name = "nombre")
		private String nombre;
		//2
		@Column(name = "apPaterno")
		private String apPaterno;
		//2
	  	@Column(name = "apMaterno")
	  	private String apMaterno; 
		//2
		@Column(name = "fechaNacimiento")
		private Date fechaNacimiento;
		//2
		@Column(name = "telefono")
		private Long telefono;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApPaterno() {
			return apPaterno;
		}
		public void setApPaterno(String apPaterno) {
			this.apPaterno = apPaterno;
		}
		public String getApMaterno() {
			return apMaterno;
		}
		public void setApMaterno(String apMaterno) {
			this.apMaterno = apMaterno;
		}
		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		public Long getTelefono() {
			return telefono;
		}
		public void setTelefono(Long telefono) {
			this.telefono = telefono;
		}
		
		
	
		

}
