package io.javapro.springbootstart.demo;


public class Topic {
	
	private String id;
	private String name;
	private String desciption;
	
	public Topic() {
	
	}
	
	
	public Topic(String id, String name, String desciption) {
		super();
		this.id = id;
		this.name = name;
		this.desciption = desciption;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
