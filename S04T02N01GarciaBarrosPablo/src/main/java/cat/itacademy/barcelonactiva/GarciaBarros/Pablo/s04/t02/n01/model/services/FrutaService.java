package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotFoundIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotValidIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotValidQuantityException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.RepeatedIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.repository.IFruta;

@Service
//Con esta notación establezco que esta clase es un Service

public class FrutaService implements IFrutaService{
//Implemento los métodos de la clase IFrutaService
	
	
	@Autowired	//Instancia lo que sigue
	private IFruta frutas;
	
	public List<Fruta> getAll(){
		return frutas.findAll();
	}
	
	public Fruta getFrutaId(int id) {
		
		if(id == 0) {
			throw new NotValidIdException("El ID no puede ser cero - ID: " + id);
		}
		if(frutas.existsById(id) == false) {
			throw new NotFoundIdException("El ID ingresado no existe - ID: " + id);
		}
		return frutas.getReferenceById(id);
	}
	
	public void deleteFrutaId(int id) {
		
		if(id <= 0) {
			throw new NotValidIdException("El id ingresado no es válido - ID: " + id);
		}
		if(frutas.existsById(id) == false) {
			throw new NotFoundIdException("El ID ingresado no existe - ID: " + id);
		}
		frutas.deleteById(id);
	}
	
	public Fruta addFruta(int id, String nombre, int cant) {
		
		if(cant < 0) {
			throw new NotValidQuantityException("La cantidad debe ser mayor a cero - CANT: " + cant);
		}
		if(id == 0) {
			throw new NotValidIdException("El ID no puede ser cero - ID: " + id);
		}
		if(frutas.existsById(id) == true) {
			throw new RepeatedIdException("El ID ingresado ya esta cargado - ID: " + id);
		}		
		Fruta newFruta = new Fruta(id, nombre, cant);
		this.frutas.save(newFruta);		
		
		return newFruta;
	}
	
	public Fruta add(int id, int cant) {
		
		if(id <= 0) {
			throw new NotValidIdException("El ID no puede menor a cero - ID: " + id);
		}
		if(frutas.existsById(id) == false) {
			throw new NotFoundIdException("El ID ingresado no existe - ID: " + id);
		}
		if((frutas.getReferenceById(id).getCant() + cant) < 0) {
			throw new NotValidQuantityException("No se puede retirar mas de lo que se tiene en stock - CANTIDAD: " + cant);
		}
		Fruta newFruit = frutas.getReferenceById(id);
		newFruit.setCant(cant += frutas.getReferenceById(id).getCant());
		this.frutas.save(newFruit);
		
		return newFruit;
	
	}
}
