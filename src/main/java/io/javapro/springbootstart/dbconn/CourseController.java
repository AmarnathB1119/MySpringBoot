package io.javapro.springbootstart.dbconn;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseBusinessConService businessController;
	
	@Autowired
	private TopicRepository repository;
	
	@RequestMapping("/topic")
	public List<TopicCrud> getAllTopic() {
		return businessController.getAllTopics();
	}

	// GET by ID
	@RequestMapping("/topic/{id}")
	public TopicCrud getTopic(@PathVariable Long id) {
		
		return businessController.getTopic(id);
		
	}

	
	
	
	  //@RequestMapping(method = RequestMethod.POST, value ="/topic")
	  
//	  @GetMapping("/topics") 
//	  public String getDesByName (@RequestParam("name")String
//	  name,@RequestParam(required = false)String description) {
//		  return "Des Name  " + name; 
//		  
//	  }
	  

	@RequestMapping(value = "/topicsCrud", method = RequestMethod.GET)
	public TopicCrud getDesByName(@RequestParam("id") Long id){
		 
		TopicCrud idc  = repository.findById(id).get();
		//String fName = idc.getName();
		//String fDescription = idc.getDesciption();
		//return "Name" + "...." +fName + " " + "Description ...." + fDescription;
		return idc;
	  }
	
	@RequestMapping(value = "/topicsCrudJson", method = RequestMethod.GET)
	public TopicView getTopicByName(@RequestParam("id") Long id){
		 
		TopicCrud idc  = repository.findById(id).get();
		
		TopicView topicView = new TopicView();
		topicView.setName(idc.getName());
		topicView.setDescription(idc.getDesciption());

		
		return topicView;
	  }
	 
	
	@RequestMapping(method = RequestMethod.POST, value ="/topic")
	public ResponseEntity<TopicCrud> addCourses(@RequestBody TopicCrud topicCrud ) {
	  
		TopicCrud refTopicCrud = repository.save(topicCrud);
	    if (refTopicCrud == null) {
	    
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    } else {
	        return new ResponseEntity<>(refTopicCrud, HttpStatus.CREATED);
	    }
	  
	}
	
		/*
		 * @RequestMapping(method = RequestMethod.PUT, value ="/topic/{id}") public void
		 * updateCourse(@RequestBody TopicCrud topicCrud, @PathVariable Long id) {
		 * businessController.getUpdateCourse(id, topicCrud); }
		 */
	
	@RequestMapping(method = RequestMethod.PUT, value ="/updatetopic")
	public ResponseEntity<Map<String, String>> updateCourse(@RequestBody TopicCrud topicCrud) {
		
		businessController.getUpdateCourses(topicCrud);
		return businessController.getUpdateCourses(topicCrud);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value ="/topic/{id}")
	public void deleteCourse(@PathVariable Long id) {
		businessController.getDelete(id);
		
	}
	
	
	//RequestHeader
	@GetMapping("/test")
	public String HandlerRequest(@RequestHeader String authorization) {
		return authorization;
	}
	//RequestHeader with Map Functionality
	@GetMapping("/testTwo")
	public String HandlerRequestTwo(@RequestHeader Map<String, String> mapValue) {
		System.out.println("Headers Value............." + mapValue);
		return "" + mapValue;
	}
	
	
	
	//ResponseHeader Object Return Type
	@GetMapping("/userHeaders")
	public ResponseEntity <Object> getUser(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("transactionId", "Demo");
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache");
        headers.add("version", "1");
        headers.add("secret", "Xyp892PB");
       
		return new ResponseEntity<Object>(headers, HttpStatus.OK);
	}
	
	
	//ResponseHeaser  String Return type
	@GetMapping("/userHeaderString")
	public ResponseEntity<String> getStringEntity(){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CACHE_CONTROL, "no-cache");
		headers.add(HttpHeaders.SET_COOKIE, "ok");
		//headers.addAll(headers);
		
		
		//return ResponseEntity.ok().header("transcationId", "22").body("Success");
		return new ResponseEntity<String>("Sucess", headers, HttpStatus.CREATED);
	}


	
	//@ResponseBody Annotation
	//if declared @RestController then no need to initiation the @ResponsBody Annotations before Method Name
	//example: public @ResponsBody TopicView getTopics(){}
	//if declared @Controller then need to initiation the @ResponsBody Annotations
	@GetMapping("/userTopics")
	public TopicView getTopics(){
		TopicView topicView = new TopicView();
		topicView.setName("Course Name");
		topicView.setDescription("Course Description");
		return topicView;
		
	}
	 
	
	
}	






