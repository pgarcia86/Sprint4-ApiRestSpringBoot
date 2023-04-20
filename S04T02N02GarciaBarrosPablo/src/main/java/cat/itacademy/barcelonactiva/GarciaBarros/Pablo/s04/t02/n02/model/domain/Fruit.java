package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //Con esta notación indico que esta clase es una entidad en la BD
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	//Con esta notación permito que me devuelva el objeto con JSON
@Table(name="frutas") //Indico el nombre de la tabla
public class Fruit {
	
	@Id //Indico que este es el ID
	@Column(name="id")	//Indico el nombre de la columna
	private int id;
	
	@Column(name="name", length=50, nullable=false) //Indico el nombre y las propiedades de la columna
	private String name;
	
	@Column(name="cant")
	private int cant;	
	
	public Fruit() {}
	
	public Fruit(int id, String name, int cant) {
		this.id = id;
		this.name = name;
		this.cant = cant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
}
