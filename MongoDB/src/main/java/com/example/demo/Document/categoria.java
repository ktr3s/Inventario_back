package com.example.demo.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categoria")
public class categoria implements Serializable {
	@Id
	
	private String idCategoria;
	
	private String nombreCategoria;
	
	private int tipoCategoria;
	
	private String descripcionCategoria;
	
	
	public categoria() {
		super();
	}
	
	
	public categoria(String nombreCategoria, int tipoCategoria, String descripcionCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
		this.tipoCategoria = tipoCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}


	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public int getTipoCategoria() {
		return tipoCategoria;
	}
	public void setTipoCategoria(int tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
	
	
}
