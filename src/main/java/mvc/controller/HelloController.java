package mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
			return "book/home";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greeting(@RequestParam(name = "person") String person,
                           @RequestParam(name = "country", required = false, defaultValue = "Viet Nam") String country,
						   @RequestParam(name = "age") int age,
                           Model model) {
       model.addAttribute("peronName", person);
	   model.addAttribute("country", country);
	   model.addAttribute("age", age);
		return "helloWorld/greeting";
	}
	@RequestMapping("/hello/{person}/{country}")
	public String greeting2(@PathVariable("person") String person,
							@PathVariable("country") String country,
							Model model) {
		model.addAttribute("personName", person);
		model.addAttribute("country", country);
		return "helloWorld/greeting";
	}
}
