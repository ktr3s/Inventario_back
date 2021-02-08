package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Document.articulo;
import com.example.demo.Repository.articuloRepository;
@Service
public class articuloService {
	
	@Autowired
	articuloRepository artRepo;
	
	
	public articulo createArticulo(articulo articulo){
		return artRepo.save(articulo);
	}
	
	//capacidad de recalcular el precio del producto a partir del precio del costo + el porcentual de variacion
	
	//mostrar cardex de poducto historial de rotacion del mismo
	
	//agregar promocion a un articulo
	
	//poner un articulo como inactivo
	
	//totalizar compras, cantidades vendidas, cantidades pedidas, cantidades caducadas,etc
	
	//descuento en articulos
	
	//codigo de barras para distintos formatos de un mismo producto
	
}
