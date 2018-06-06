package todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CHALLENGES")
public class Challenge {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="challengeno")
	@SequenceGenerator(name="challengeno",sequenceName="challengeseq")
	@Column
	@Getter
	@Setter
	private long id;
	
    @Setter
    @Getter
    private String challenge;
 }