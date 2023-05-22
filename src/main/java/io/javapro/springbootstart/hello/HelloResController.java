package io.javapro.springbootstart.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResController {
	
	@RequestMapping("/abc")
	public String message() {
		return "Hello Nunam";
	}
}
