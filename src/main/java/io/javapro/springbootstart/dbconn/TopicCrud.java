package io.javapro.springbootstart.dbconn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class TopicCrud {
	
	
	@Id
	//@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//@Column(name = "name")
	private String name;
	
	
	 //@Column(name = "desciption")
	 private String desciption;
	  
	 public TopicCrud() {
 		
    	}
	
	
	public TopicCrud(Long id, String name, String desciption) {
		super();
		this.id = id;
		this.name = name;
		this.desciption = desciption;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	

}
