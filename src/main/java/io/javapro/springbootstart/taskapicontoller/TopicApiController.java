package io.javapro.springbootstart.taskapicontoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javapro.springbootstart.demo.Topic;

@RestController
public class TopicApiController {
	
	@Autowired
	private TopicBusinessService topicBusinessService;
	
	@RequestMapping("/topics") //default 
    //#@RequestMapping(method= RequestMethod.GET, value="/topics") Syntax
	public List<Topic> getAllTopic(){
		return topicBusinessService.getAllTopics();
	
	
	}
	
	//GET
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicBusinessService.getTopic(id);
	
	}
	
	//POST
	//#below line, Mapping the request,to POST with /topics
	@RequestMapping(method= RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topics) {
		topicBusinessService.addTopic(topics);
	}
	
	//PUT
	//Updating particular value by Identifying it position
	@RequestMapping(method =RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopics(@RequestBody Topic topics, @PathVariable String id) {
		topicBusinessService.updateTopic(id, topics);
	}
	
	
	//Delete
		@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{name}")
		public void deleteTopic(@PathVariable String name ) {
			topicBusinessService.deleteTopic(name);
		}
	
}









