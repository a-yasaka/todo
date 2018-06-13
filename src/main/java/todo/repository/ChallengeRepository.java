package todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import todo.model.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, String>{
	List<Challenge> findAll();
	Challenge findById(long id);
	@Query(value="select * from challenges order by state desc,id desc",nativeQuery=true)
	List<Challenge> makeView();
}
