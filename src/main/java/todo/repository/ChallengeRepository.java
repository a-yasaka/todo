package todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import todo.model.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, String>{
	List<Challenge> findAll();
}
