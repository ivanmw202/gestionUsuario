package com.gestionUser.dto;

public class DomicilioDTO {
	private Long id;
	private String calle;
	private Long numeroInterior;
	private Long numeroExterior;
	private String colonia; 
	private Long cp;
	private String municipio;
	private String estado;
	private Long usuarioId;
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
	public Long getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(Long numeroExterior) {
		this.numeroExterior = numeroExterior;
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
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	

}
