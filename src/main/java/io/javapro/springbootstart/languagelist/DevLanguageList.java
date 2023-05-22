package io.javapro.springbootstart.languagelist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevLanguageList {
	
	@RequestMapping("/language")
	public String devLanguage() {
		return "Java Spring boot and Hibernet";
	}
}