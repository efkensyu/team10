package com.example.demo.team10.petregister;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetRegisterController {
	//private final Team10PetRegisterRepository repository;

	@GetMapping("/register")			
	public String index (Model model) {
		//List<Team10PetRegister> userDataList = repository.findAll();
		//model.addAttribute("userDataList", userDataList);
		return "team10/petregister/Team10PetRegisterIn";	
	}
}