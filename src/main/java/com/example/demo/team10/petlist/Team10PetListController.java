package com.example.demo.team10.petlist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team10.entity.Team10PetRegister;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetListController {
	private final Team10PetListService service;
	
	@GetMapping("/team10/petlist")			
	public String list(Model model) {
		List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();

		model.addAttribute("DataList", DataList);
	    return "/team10/petlist/Team10PetList";	
	}

	@PostMapping("/team10/petlist/details")
	public String details(@RequestParam("petId") int petId, Model model){
		Team10PetRegister pet = service.getPetById(petId);
	    model.addAttribute("pet", pet);
		return "/team10/petlist/Team10PetListDetails";
		
	}
}
