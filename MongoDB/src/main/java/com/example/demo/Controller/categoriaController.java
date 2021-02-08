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

import com.example.demo.Document.categoria;
import com.example.demo.Repository.categoriaRepository;
import com.example.demo.Service.bodegaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class categoriaController {

	@Autowired
	categoriaRepository catRepo;
	
	@GetMapping("/listar_categorias")
	  public ResponseEntity<List<categoria>> getAllBodegas(@RequestParam(required = false) String nombreCategoria) {
		try {
		    List<categoria>categorias = new ArrayList<categoria>();

		    if (nombreCategoria == null)
		    	catRepo.findAll().forEach(categorias::add);
		    else
		    	catRepo.findByNombreCategoria(nombreCategoria).forEach(categorias::add);

		    if (categorias.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(categorias, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	
	@GetMapping("/listar_categoria/{idcategoria}")
	public ResponseEntity<categoria> getIdcategoria(@PathVariable("idcategoria") String idcategoria) {
	  Optional<categoria> categoriaData = catRepo.findById(idcategoria);

	  if (categoriaData.isPresent()) {
	    return new ResponseEntity<>(categoriaData.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	@DeleteMapping("/borrar_categoria/{id}")
	public ResponseEntity<HttpStatus> deletecategoria(@PathVariable("id") String id) {
	  try {
	    catRepo.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}	
	
	@DeleteMapping("/borrar_todas_categorias")
	public ResponseEntity<HttpStatus> deleteAllcategorias() {
	  try {
	    catRepo.deleteAll();
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PostMapping("/crear_categoria")
	public ResponseEntity<categoria> createTutorial(@RequestBody categoria categoria) {
	  try {
		 categoria bode = catRepo.save(new categoria(categoria.getNombreCategoria(), categoria.getTipoCategoria(), categoria.getDescripcionCategoria()));
	    return new ResponseEntity<>(bode, HttpStatus.CREATED);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/actualizar_categoria/{id}")
	public ResponseEntity<categoria> updatecategoria(@PathVariable("id") String id, @RequestBody categoria categoria) {
	  Optional<categoria> categoriaData = catRepo.findById(id);

	  if (categoriaData.isPresent()) {
	    categoria _categoria = categoriaData.get();
	    _categoria.setNombreCategoria(categoria.getNombreCategoria());
	    _categoria.setTipoCategoria(categoria.getTipoCategoria());
	    _categoria.setDescripcionCategoria(categoria.getDescripcionCategoria());
	    return new ResponseEntity<>(catRepo.save(_categoria), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
}
