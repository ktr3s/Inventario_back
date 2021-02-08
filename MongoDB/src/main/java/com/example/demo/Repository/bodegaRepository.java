package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.Document.bodega;

@Repository
public interface bodegaRepository extends MongoRepository<bodega, String>{

	
	 List<bodega> findByNombreBodega(String nombreBodega) ;
	 Optional<bodega> findByIdBodega(String idbodega) ;
	 List<bodega> findAll() ;
	 void deleteByIdBodega(String idbodega);
	 
}
