package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import com.example.demo.Document.categoria;

public interface categoriaService {

	public List<categoria> findAll(Sort sort);
	
	public Page<categoria> findAll(Pageable pageable);
	
	public categoria findById(String id);
	
	public void delete (String id);
	
	public categoria save(categoria categoria);
	
	//modicar su valos de acuerdo a porcentajes
	//crear grupos de articulos
	//crear distintos formatos de ventas hasta 5 tipos y calcular el precio
	
}
