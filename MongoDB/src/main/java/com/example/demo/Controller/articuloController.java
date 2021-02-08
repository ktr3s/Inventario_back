package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.example.demo.Document.articulo;
import com.example.demo.Document.bodega;
import com.example.demo.Repository.articuloRepository;
import com.example.demo.Repository.bodegaRepository;
import com.example.demo.Service.articuloService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class articuloController {
	
	@Autowired
	articuloRepository artRepo;
	articuloService service;
	
	@GetMapping("/listar_articulos")
	  public ResponseEntity<List<articulo>> getAllBodegas(@RequestParam(required = false) String nombreArticulo) {
		try {
		    List<articulo>articulos = new ArrayList<articulo>();

		    if (nombreArticulo == null)
		    	artRepo.findAll().forEach(articulos::add);
		    else
		    	artRepo.findByNombreArticulo(nombreArticulo).forEach(articulos::add);

		    if (articulos.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(articulos, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	
	@GetMapping("/listar_articulo/{idarticulo}")
	public ResponseEntity<articulo> getIdarticulo(@PathVariable("idarticulo") String idarticulo) {
	  Optional<articulo> articuloData = artRepo.findById(idarticulo);

	  if (articuloData.isPresent()) {
	    return new ResponseEntity<>(articuloData.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	@DeleteMapping("/borrar_articulo/{id}")
	public ResponseEntity<HttpStatus> deletearticulo(@PathVariable("id") String id) {
	  try {
	    artRepo.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}	
	
	@DeleteMapping("/borrar_todos_articulos")
	public ResponseEntity<HttpStatus> deleteAllarticulos() {
	  try {
	    artRepo.deleteAll();
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PostMapping("/crear_articulo")
	public ResponseEntity<articulo> createTutorial(@RequestBody articulo articulo) {
	  try {
		 articulo bode = artRepo.save(new articulo(articulo.getNombreArticulo(), articulo.getCantidadArticulo(), articulo.getPesoArticulo(), articulo.getPrecioArticulo(),articulo.getIvaArticulo()));
	    return new ResponseEntity<>(bode, HttpStatus.CREATED);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/actualizar_articulo/{id}")
	public ResponseEntity<articulo> updatearticulo(@PathVariable("id") String id, @RequestBody articulo articulo) {
	  Optional<articulo> articuloData = artRepo.findById(id);

	  if (articuloData.isPresent()) {
	    articulo _articulo = articuloData.get();
	    _articulo.setNombreArticulo(articulo.getNombreArticulo());
	    _articulo.setCantidadArticulo(articulo.getCantidadArticulo());
	    _articulo.setPesoArticulo(articulo.getPesoArticulo());
	    _articulo.setPrecioArticulo(articulo.getPrecioArticulo());
	    _articulo.setIvaArticulo(articulo.getIvaArticulo());
	    return new ResponseEntity<>(artRepo.save(_articulo), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
}
