package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.service;

import java.util.List;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.domain.Fruit;

public interface IFruitService {
	
	public List<Fruit> getAll();
	
	public Fruit getById(int id);
	
	public void deleteById(int id);
	
	public Fruit updateStock(int id, int cant);
	
	public Fruit add(int id, String name, int cant);
	

}
