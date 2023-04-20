package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//Con esta notación establezco que esta clase es una entidad
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="frutas")
public class Fruta {
	
	
	@Id
	private int id;
	private String nombre;
	private int cant;	
	
	public Fruta(int id, String nombre, int cant) {
		this.id = id;
		this.nombre = nombre;
		this.cant = cant;
	}
	
	public Fruta() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	
	public void agregarCant(int inc) {
		this.cant += inc;
	}
}
