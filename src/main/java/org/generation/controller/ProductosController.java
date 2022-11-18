package org.generation.controller;



import org.generation.entity.Productos;
import org.generation.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins="*")
public class ProductosController {
	
	@Autowired
	ProductosService productosService;
	
	@GetMapping
	  public @ResponseBody Iterable<Productos> getAllProductos() {
	    return productosService.getAllProductos();
	  }
	
	@PostMapping 
	@ResponseBody
	public ResponseEntity<?> addNewProdcutos(@RequestBody Productos productos) {
		try {
			
			return new ResponseEntity<Productos>(productosService.saveProductos(productos), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
	

}
