package app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Hello {
	
	@Value("${welcome.message}")
	private String message;
	@Value("${valor}")
	private List<Integer> valor;
	//private List<Integer> valor = Arrays.asList(20,30,40);
	@GetMapping(path = "/hello")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("tasks", valor);
		return "welcome";
	}
	@GetMapping(path = "/helloworld")
	public String mainWithParam(@RequestParam(name="name",required = false, defaultValue = "") String name,Model model) {
		name = message+" "+name;
		model.addAttribute("message", name);
		return "welcome";
	}
	
	@GetMapping(path = "/helloworld/{name}")
	public String mainWithParam2(@PathVariable(name = "name") String name,Model model) {
		name = message+" "+name;
		model.addAttribute("message", name);
		return "welcome";
	}
}
