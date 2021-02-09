package fi.k2021eero.Week1Exe2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class conController {
	@RequestMapping("/hello")
public String hello(String location, String name) {
		return "Welcome to the " + location + " " + name;
	}
}
