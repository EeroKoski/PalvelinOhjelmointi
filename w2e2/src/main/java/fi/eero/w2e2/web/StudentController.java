package fi.eero.w2e2.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.eero.w2e2.domain.Student;

@Controller

public class StudentController {	
	
	@RequestMapping("/hello")
	public String showStudents(Model model) {
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Barack", "Obama"));
		studentList.add(new Student("Donald", "Trump"));
		studentList.add(new Student("George", "Bush"));
		System.out.println(studentList);
		
		model.addAttribute("students", studentList);
		return "students";

		
	}	
}
