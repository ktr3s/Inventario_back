package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import com.example.demo.Document.categoria;

@Repository
public interface categoriaRepository extends MongoRepository<categoria, Serializable>{

	List<categoria> findByNombreCategoria(String nombreCategoria) ;
	
}
