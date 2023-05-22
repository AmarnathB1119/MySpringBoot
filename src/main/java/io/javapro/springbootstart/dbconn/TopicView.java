package io.javapro.springbootstart.dbconn;

public class TopicView {

	
	private String Name;
	private String Description;
	
	
	public TopicView() {
		
	}
	
	
	public TopicView(String name, String description) {
		super();
		Name = name;
		Description = description;
	}
	
	
	
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
