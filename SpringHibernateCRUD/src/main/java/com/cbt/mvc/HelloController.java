package com.cbt.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cbt.tutorials.model.Person;
import com.cbt.tutorials.service.PersonService;

@Controller
public class HelloController {

	private PersonService personService;

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}



	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.list());
		
		return "home";
	}
	
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.save(p);
		}else{
			//existing person, call update
			this.personService.update(p);
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.remove(id);
        return "redirect:/";
    }
	
	 @RequestMapping("/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, Model model){
	        model.addAttribute("person", this.personService.getPersonById(id));
	        model.addAttribute("listPersons", this.personService.list());
	        return "home";
	   }

}
