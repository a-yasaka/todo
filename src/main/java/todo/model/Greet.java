package todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GREETS")
public class Greet {
	@Id
	@Setter
	@Getter
	private int id;
	
    @Setter
    @Getter
    private String greet;
 }