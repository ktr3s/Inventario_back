package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Document.bodega;
import com.example.demo.Repository.bodegaRepository;
import com.example.demo.Service.bodegaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class bodegaController {

	@Autowired
	bodegaRepository bodRepo;
	bodegaService service;
	
	
	@GetMapping("/listar_bodegas")
	  public ResponseEntity<List<bodega>> getAllBodegas(@RequestParam(required = false) String nombreBodega) {
		try {
		    List<bodega>bodegas = new ArrayList<bodega>();

		    if (nombreBodega == null)
		    	bodRepo.findAll().forEach(bodegas::add);
		    else
		    	bodRepo.findByNombreBodega(nombreBodega).forEach(bodegas::add);

		    if (bodegas.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(bodegas, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }

	@GetMapping("/listar_bodega/{idbodega}")
	public ResponseEntity<bodega> getIdBodega(@PathVariable("idbodega") String idbodega) {
	  Optional<bodega> bodegaData = bodRepo.findById(idbodega);

	  if (bodegaData.isPresent()) {
	    return new ResponseEntity<>(bodegaData.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	
	

	@DeleteMapping("/borrar_bodega/{id}")
	public ResponseEntity<HttpStatus> deleteBodega(@PathVariable("id") String id) {
	  try {
	    bodRepo.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}	
	
	@DeleteMapping("/borrar_todas_bodegas")
	public ResponseEntity<HttpStatus> deleteAllBodegas() {
	  try {
	    bodRepo.deleteAll();
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PostMapping("/crear_bodegas")
	public ResponseEntity<bodega> createTutorial(@RequestBody bodega bodega) {
	  try {
		 bodega bode = bodRepo.save(new bodega(bodega.getNombreBodega(), bodega.getTipoBodega(), bodega.getCapacidadBodega(), bodega.getDescripcionBodega(),bodega.getDireccionBodega()));
	    return new ResponseEntity<>(bode, HttpStatus.CREATED);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/actualizar_bodega/{id}")
	public ResponseEntity<bodega> updatebodega(@PathVariable("id") String id, @RequestBody bodega bodega) {
	  Optional<bodega> bodegaData = bodRepo.findById(id);

	  if (bodegaData.isPresent()) {
	    bodega _bodega = bodegaData.get();
	    _bodega.setNombreBodega(bodega.getNombreBodega());
	    _bodega.setTipoBodega(bodega.getTipoBodega());
	    _bodega.setCapacidadBodega(bodega.getCapacidadBodega());
	    _bodega.setDescripcionBodega(bodega.getDescripcionBodega());
	    _bodega.setDireccionBodega(bodega.getDireccionBodega());
	    return new ResponseEntity<>(bodRepo.save(_bodega), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
}
