package com.example.demo.team10.peteditor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.petlist.Team10PetListService;

import lombok.RequiredArgsConstructor;

@Controller	
@RequiredArgsConstructor	
public class Team10PetEditorController {
	private final Team10PetListService service;
	
	@GetMapping("/team10/peteditor")			
	public String list(Model model) {
		List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();
		model.addAttribute("DataList", DataList);
	    return "/team10/petlist/Team10PetList";	
	}
	
	@GetMapping("/team10/peteditor")
	public String editForm(@RequestParam("petId") int petId, Model model) {
	    Team10PetRegister pet = service.getPetById(petId);
	    //List<Team10BreedList> breedList = breedRepository.findAll();
	    model.addAttribute("pet", pet);
	    //model.addAttribute("breedList", breedList);
	    return "/team10/petlist/Team10PetListEdit";
	}
}
