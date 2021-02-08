package com.example.demo.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articulo")
public class articulo implements Serializable {
	@Id
	@NotNull
	private String idArticulo;
	@NotNull
	private String nombreArticulo;
	@NotNull
	private int cantidadArticulo;
	@NotNull
	private float precioArticulo;
	@NotNull
	private float pesoArticulo;
	@NotNull
	private int ivaArticulo;

	
	
	public articulo() {
		super();
	}

	
	public articulo(@NotNull String nombreArticulo, @NotNull int cantidadArticulo, @NotNull float precioArticulo,
			@NotNull float pesoArticulo, @NotNull int ivaArticulo) {
		super();
		this.nombreArticulo = nombreArticulo;
		this.cantidadArticulo = cantidadArticulo;
		this.precioArticulo = precioArticulo;
		this.pesoArticulo = pesoArticulo;
		this.ivaArticulo = ivaArticulo;
	}


	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public int getCantidadArticulo() {
		return cantidadArticulo;
	}

	public void setCantidadArticulo(int cantidadArticulo) {
		this.cantidadArticulo = cantidadArticulo;
	}

	public float getPrecioArticulo() {
		return precioArticulo;
	}

	public void setPrecioArticulo(float precioArticulo) {
		this.precioArticulo = precioArticulo;
	}

	public float getPesoArticulo() {
		return pesoArticulo;
	}

	public void setPesoArticulo(float pesoArticulo) {
		this.pesoArticulo = pesoArticulo;
	}

	public int getIvaArticulo() {
		return ivaArticulo;
	}

	public void setIvaArticulo(int ivaArticulo) {
		this.ivaArticulo = ivaArticulo;
	}
	
	
	
	
}
