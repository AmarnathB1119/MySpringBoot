package io.javapro.springbootstart.demo;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseList {
	
	@RequestMapping("/courselist")
	public List<Topic> getAllCourseTopic(){
		return Arrays.asList(
				new Topic("1", "Spring", "Web Application"),
				new Topic("2", "Kotlin", "Mobile Application"),
				new Topic("2", "Flutter", "Android & IOS Application"),
				new Topic("2", "React", "Android & IOS Application & web")
				);
	}
}
