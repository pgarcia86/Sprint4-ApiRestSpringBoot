package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.domain.Fruta;

public interface IFrutaService{
	
	public List<Fruta> getAll();
	
	public Fruta getFrutaId(int id);
	
	public void deleteFrutaId(int id);
	
	public Fruta addFruta(int id, String nombre, int cant);
	
	public Fruta add(int id, int cant);

}
