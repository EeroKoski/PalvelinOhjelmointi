package fi.eero.w2e1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class PersonController {
	
	@RequestMapping("/hello")
	public String welcomePerson(@RequestParam(name="age") int age,
		@RequestParam(name="name") String personName, Model model) {
		model.addAttribute("name", personName);
		model.addAttribute("age", age);
		return "helloPerson";
	}
	
	
	

}
