package com.example.demo.team10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team10.entity.Team10BreedList;

@Controller

public class Team10BreedListController {
	private final Team10Service team10service;
	
	public Team10BreedListController(Team10Service team10service) {
        this.team10service = team10service;
    }
	
	@PostMapping(value="/team10/breedlist/details",params="breedlistdetails")
    public String showDetails(@RequestParam("breedId") Integer breedId, Model model) {
		Team10BreedList targetBreed = team10service.getBreedByBreedId(breedId);
		model.addAttribute("breed", targetBreed);
		return "team10/Team10BreedList_details";
	}
	
}
