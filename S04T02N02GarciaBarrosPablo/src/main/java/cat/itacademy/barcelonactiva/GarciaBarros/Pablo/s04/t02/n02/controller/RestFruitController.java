package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.service.FruitService;


@RestController //Indico que este es el controlador Rest
@RequestMapping("/frutas")
public class RestFruitController {
	
	@Autowired //Creara una instancia del objeto de debajo
	private FruitService fruits;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruit>> getAll(){
		return new ResponseEntity<>(fruits.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruit> getOne(@PathVariable("id") int id) {
		return new ResponseEntity<Fruit>(fruits.getById(id), HttpStatus.OK);
	}
	
	@PostMapping("/add/{id}/{name}/{cant}")
	public ResponseEntity<Fruit> add(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("cant") int cant) {
		
		return new ResponseEntity<Fruit>(fruits.add(id, name, cant), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}/{cant}")
	public ResponseEntity<Fruit> updateStock(@PathVariable("id") int id, @PathVariable("cant") int cant) {
		return new ResponseEntity<Fruit>(fruits.updateStock(id, cant), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		fruits.deleteById(id);
		return new ResponseEntity<String>("Se eliminó el registro ", HttpStatus.OK);
	}

}
