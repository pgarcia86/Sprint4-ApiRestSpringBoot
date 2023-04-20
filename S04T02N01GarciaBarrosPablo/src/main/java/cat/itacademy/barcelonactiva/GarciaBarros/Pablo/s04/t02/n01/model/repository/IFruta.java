package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.model.domain.Fruta;

//Esta interfaz extiende de JpaRepository para poder utilizar sus metodos en la clase FrutaService

public interface IFruta extends JpaRepository<Fruta, Integer>{

}
