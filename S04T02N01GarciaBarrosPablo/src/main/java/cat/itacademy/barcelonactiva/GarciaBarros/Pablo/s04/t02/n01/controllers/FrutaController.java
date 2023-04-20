package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.services.FrutaService;



@Controller
//Con la notación controller establezco que esta clase es un controller
@RequestMapping("/fruta")
public class FrutaController {
	
	@Autowired //Esta notación dice que debe instanciar un objeto de la siguiente instancia
	private FrutaService frutas;
	
	@PostMapping("/add/{id}/{nombre}/{cant}")
	public ResponseEntity<Fruta> paginaAgregarProducto(@PathVariable("id") int id, @PathVariable("nombre") String nombre, 
			@PathVariable("cant") int cant) {
		
		return new ResponseEntity<Fruta>(frutas.addFruta(id, nombre, cant), HttpStatus.CREATED);
	}
	
	@PostMapping("/update/{id}/{cant}")
	public ResponseEntity<Fruta> paginaActualizadBaseDatos(@PathVariable("id") int id, @PathVariable("cant") int cant) {
		
		return new ResponseEntity<Fruta>(frutas.add(id, cant), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> borrarPorId(@PathVariable("id") int id) {
		frutas.deleteFrutaId(id);
		return new ResponseEntity<String>("Se eliminó el registro", HttpStatus.OK);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruta> getOne(@PathVariable("id") int id) {
		
		return new ResponseEntity<Fruta>(frutas.getFrutaId(id), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruta>> getAll() {
		return new ResponseEntity<>(frutas.getAll(), HttpStatus.OK);
	}
	
}
