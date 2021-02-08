package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Document.articulo;

@Repository
public interface articuloRepository extends MongoRepository<articulo, String>{


	 List<articulo> findByNombreArticulo(String nombreArticulo) ;
	 
	
}
