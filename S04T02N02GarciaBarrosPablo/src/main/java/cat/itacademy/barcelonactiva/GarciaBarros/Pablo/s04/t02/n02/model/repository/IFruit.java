package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.model.domain.Fruit;


public interface IFruit extends JpaRepository<Fruit, Integer>{

}
