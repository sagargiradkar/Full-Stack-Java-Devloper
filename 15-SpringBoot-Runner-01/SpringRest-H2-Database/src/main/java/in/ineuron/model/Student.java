package in.ineuron.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
	
	private Integer sid;
	private String name;
	private String address;
	private String mail; 
	
}
