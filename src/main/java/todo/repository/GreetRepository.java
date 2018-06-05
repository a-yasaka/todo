package todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todo.model.Greet;

public interface GreetRepository extends JpaRepository<Greet, String>{

}
