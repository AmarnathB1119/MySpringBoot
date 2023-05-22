package io.javapro.springbootstart.taskapicontoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.javapro.springbootstart.demo.Topic;

@Service
public class TopicBusinessService {
	

	
 private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Spring", "Web Application"),
			new Topic("2", "Kotlin", "Mobile Application"),
			new Topic("3", "Flutter", "Android & IOS Application"),
			new Topic("4", "React", "Android & IOS Application & web")
			));
 
 public List<Topic> getAllTopics(){
	 return topics;
 }
 
 public Topic getTopic(String id) {
	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
 }

public void addTopic(Topic topic) {
	topics.add(topic);
	
}

public void updateTopic(String id, Topic topic) {
	for(int i=0; i<topics.size(); i++) {
		Topic t = topics.get(i);
		if(t.getId().equals(id)) {
			topics.set(i, topic);
			return;
		}
	}
}

public void deleteTopic(String name) {
	topics.removeIf(t -> t.getName().equals(name));
}

}




