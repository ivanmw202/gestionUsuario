package com.gestionUser.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table (name = "domicilio")
@Entity 
public class Domicilio {
		//2
		@Column(name = "id")
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ2")
		@SequenceGenerator(sequenceName = "customer_seq1", allocationSize = 1, name = "CUST_SEQ2")
		private Long id;
		//2
		@Column(name = "calle")
		private String calle;
		//2
		@Column(name = "numeroInterior")
		private Long numeroInterior;
		//2
		@Column(name = "numeroExteriro")
		private Long numeroxteriro;
		//2
		@Column(name = "colonia")
		private String colonia;
		//2
		@Column(name = "cp")
		private Long cp;
		//2
		@Column(name = "municipio")
		private String municipio;
		//2
		@Column(name = "estado")
		private String estado;
		
		//3
		@JoinColumn (name = "usuario_id")
		@ManyToOne
		private Usuario usuario;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCalle() {
			return calle;
		}

		public void setCalle(String calle) {
			this.calle = calle;
		}

		public Long getNumeroInterior() {
			return numeroInterior;
		}

		public void setNumeroInterior(Long numeroInterior) {
			this.numeroInterior = numeroInterior;
		}

		public Long getNumeroxteriro() {
			return numeroxteriro;
		}

		public void setNumeroxteriro(Long numeroxteriro) {
			this.numeroxteriro = numeroxteriro;
		}

		public String getColonia() {
			return colonia;
		}

		public void setColonia(String colonia) {
			this.colonia = colonia;
		}

		public Long getCp() {
			return cp;
		}

		public void setCp(Long cp) {
			this.cp = cp;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		

		
		
}
