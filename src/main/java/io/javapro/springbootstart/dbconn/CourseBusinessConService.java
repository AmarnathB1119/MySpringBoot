package io.javapro.springbootstart.dbconn;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CourseBusinessConService {
	
	@Autowired
	private TopicRepository repository;
	

	
	public List<TopicCrud> getAllTopics() {
		return repository.findAll();
	}


	public TopicCrud getTopic(Long id) {
		return repository.findById(id).get();
	}


	
	 public void addCourse(TopicCrud topicCrud) { 
		 repository.save(topicCrud); 
		 }


	public String getUpdateCourse(Long id, TopicCrud topicCrud) {
		  
	    Optional<TopicCrud> result = repository.findById(id);
	    
	    if(result.isPresent()) {
	    	
			 repository.save(topicCrud);
		    	String idStatus = "200 updated";

			 return idStatus;
			 
	    }else {	

	    	System.out.println("not found");
	    	String idStatus = "202 Error User Not found !";
	    	
	    	return idStatus;
	    	 
	    }
			
	}
	
	public ResponseEntity<Map<String, String>> getUpdateCourses(Long id, TopicCrud topicCrud) {
		
		 Optional<TopicCrud> result = repository.findById(id);
		 
		 if(result.isPresent()) {
		    	
			 repository.save(topicCrud);
			 
			
		    	
			 Map<String, String> successResponse = Map.of(
			    		
	    		      "message", "Updated",
	    		      "status", HttpStatus.OK.toString()
	    		  );

				return new ResponseEntity<>(successResponse, HttpStatus.OK);
			 
	    }else {	

	    	System.out.println("not found");
	    	
	    	Map<String, String> errorResponse = Map.of(
	    		
	    		      "message", "Not Founded",
	    		      "status", HttpStatus.BAD_REQUEST.toString()
	    		  );

	    	
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Updated");
	    	  return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	    	 
	    }
		    
	}
	
	
		
	

	public void getDelete(Long id) {
		repository.deleteById(id);;
		
	}
}
