package com.example.demo.team10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller	
@RequiredArgsConstructor	

public class Team10TopController {
	//private final Team10Service team10service;
	
		
	@GetMapping("/team10/inu")			
	public String index () {					
		return "team10/Team10Top";		
	}
	
	/*@PostMapping(value="/team10/inu",params="breedlist")
	public String send1(Model model) {
	List<Team10BreedList> breeds = Team10Service.findAll();
	model.addAttribute("breeds", breeds);
		return "Team10BreedList";
	}*/

	/*@PostMapping(value="/team10/inu",params="petregister")
	public String send2(Model model) {
		return "Team10PetRegister";
	}
	
	@PostMapping(value="/team10/inu",params="petlist")
	public String send3(Model model) {
		return "Team10PetList";
	}*/
		
	
}
