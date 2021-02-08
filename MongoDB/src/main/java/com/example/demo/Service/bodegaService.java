package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Document.bodega;
import com.example.demo.Repository.bodegaRepository;
import com.example.demo.Exception.RecordNotFoundException;

@Service
@Transactional
public class bodegaService {

	@Autowired
	bodegaRepository bodRepo;
	
	public List<bodega> list(){
		return bodRepo.findAll();  
	}
	
	public Optional<bodega> getOne(String idbodega){
		return bodRepo.findById(idbodega); 
	}
	
	
	
	public bodega updateBodega(bodega bodega) throws RecordNotFoundException {
		Optional<bodega> bodegaTemp = bodRepo.findByIdBodega(bodega.getIdBodega());
	
		if(bodegaTemp.isPresent()){
			return bodRepo.save(bodega);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	
	public void deleteBodegaById(String idbodega) throws RecordNotFoundException{
		Optional<bodega> bodega = bodRepo.findByIdBodega(idbodega);
		if(bodega.isPresent()) {
		bodRepo.deleteByIdBodega(idbodega);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	//mostrar la bodega de la que se obtiene la mercaderia
}