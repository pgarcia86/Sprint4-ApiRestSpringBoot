package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions.NotValidIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions.NotValidQuantityException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions.NotFoundIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions.RepeatedIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.repository.IFruit;

@Service
public class FruitService implements IFruitService{

	@Autowired //Cuando tenga que instanciar el objeto de debajo, creará una instancia de ese tipo
	private IFruit fruit;
	
	@Override
	public List<Fruit> getAll() {
		return fruit.findAll();
	}

	@Override
	public Fruit getById(int id) {	
		if(id == 0) {
			throw new NotValidIdException("El ID no puede ser cero - ID: " + id);
		}
		if(fruit.existsById(id) == false) {
			throw new NotFoundIdException("El ID ingresado no existe - ID: " + id);
		}
		return fruit.getReferenceById(id);
	}

	@Override
	public void deleteById(int id) {
		if(id <= 0) {
			throw new NotValidIdException("El id ingresado no es válido - ID: " + id);
		}
		if(fruit.existsById(id) == false) {
			throw new NotFoundIdException("El ID ingresado no existe - ID: " + id);
		}
		fruit.deleteById(id);
	}

	@Override
	public Fruit add(int id, String name, int cant) {	
		if(cant < 0) {
			throw new NotValidQuantityException("La cantidad debe ser mayor a cero - CANT: " + cant);
		}
		if(id == 0) {
			throw new NotValidIdException("El ID no puede ser cero - ID: " + id);
		}
		if(fruit.existsById(id) == true) {
			throw new RepeatedIdException("El ID ingresado ya esta cargado - ID: " + id);
		}		
		Fruit newFruit = new Fruit(id, name, cant);
		this.fruit.save(newFruit);		
		
		return newFruit;
	}
	

	@Override
	public Fruit updateStock(int id, int cant) {	
		
		if(id <= 0) {
			throw new NotValidIdException("El ID no puede menor a cero - ID: " + id);
		}
		if(fruit.existsById(id) == false) {
			throw new NotFoundIdException("El ID ingresado no existe - ID: " + id);
		}
		if((fruit.getReferenceById(id).getCant() + cant) < 0) {
			throw new NotValidQuantityException("No se puede retirar mas de lo que se tiene en stock - CANTIDAD: " + cant);
		}
		Fruit newFruit = fruit.getReferenceById(id);
		newFruit.setCant(cant += fruit.getReferenceById(id).getCant());
		this.fruit.save(newFruit);
		
		return newFruit;
	}

}
