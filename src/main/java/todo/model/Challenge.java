package todo.model;

import java.util.Date;

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
    
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Date startDate;
    
    @Setter
    @Getter
    private Date endDate;
    
    @Setter
    @Getter
    private String state;
    
    @Setter
    @Getter
    private String memo;
 }