package com.example.demo.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bodega")
public class bodega implements Serializable {
	@Id
	private String idBodega;
	
	private String nombreBodega;
	
	private int tipoBodega;
	
	private int capacidadBodega;
	
	private String descripcionBodega;
	
	private String direccionBodega;
	
	
	
	
	
	public bodega() {
		super();
	}
	
	
	public bodega( String nombreBodega, int tipoBodega, int capacidadBodega, String descripcionBodega,
			String direccionBodega) {
		super();
		
		this.nombreBodega = nombreBodega;
		this.tipoBodega = tipoBodega;
		this.capacidadBodega = capacidadBodega;
		this.descripcionBodega = descripcionBodega;
		this.direccionBodega = direccionBodega;
	}


	public String getIdBodega() {
		return idBodega;
	}
	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}
	public String getNombreBodega() {
		return nombreBodega;
	}
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	public int getTipoBodega() {
		return tipoBodega;
	}
	public void setTipoBodega(int tipoBodega) {
		this.tipoBodega = tipoBodega;
	}
	public int getCapacidadBodega() {
		return capacidadBodega;
	}
	public void setCapacidadBodega(int capacidadBodega) {
		this.capacidadBodega = capacidadBodega;
	}
	public String getDescripcionBodega() {
		return descripcionBodega;
	}
	public void setDescripcionBodega(String descripcionBodega) {
		this.descripcionBodega = descripcionBodega;
	}
	public String getDireccionBodega() {
		return direccionBodega;
	}
	public void setDireccionBodega(String direccionBodega) {
		this.direccionBodega = direccionBodega;
	}
	
	
}
