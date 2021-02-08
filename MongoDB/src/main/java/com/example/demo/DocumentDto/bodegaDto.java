package com.example.demo.DocumentDto;



import javax.validation.constraints.NotBlank;

public class bodegaDto {
	
	@NotBlank
	private String nombreBodega;
	@NotBlank
	private int tipoBodega;
	@NotBlank
	private int capacidadBodega;
	@NotBlank
	private String descripcionBodega;
	@NotBlank
	private String direccionBodega;

	public bodegaDto() {
		
	}

	public bodegaDto(@NotBlank String nombreBodega, @NotBlank int tipoBodega, @NotBlank int capacidadBodega,
			@NotBlank String descripcionBodega, @NotBlank String direccionBodega) {
		super();
		this.nombreBodega = nombreBodega;
		this.tipoBodega = tipoBodega;
		this.capacidadBodega = capacidadBodega;
		this.descripcionBodega = descripcionBodega;
		this.direccionBodega = direccionBodega;
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
