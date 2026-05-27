package com.example.demo.team10;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team10.entity.Team10BreedList;
import com.example.demo.team10.top.Team10Service;

@Controller

public class Team10BreedListController {
	private final Team10Service team10service;
	
	public Team10BreedListController(Team10Service team10service) {
        this.team10service = team10service;
    }
	//犬種一覧ボタンの処理
		@PostMapping(value="/team10/breedlist",params="breedlist")
		public String send1(Model model) {
			List<Team10BreedList> breeds = team10service.findAll();
			model.addAttribute("breeds", breeds);
			return "team10/Team10BreedList";
		}
	
	//breedlistHTMLにあるbreedlistdetailsボタンが押されると、breedlistdetailsHTMLに飛ばす
	@PostMapping(value="/team10/breedlist/details",params="breedlistdetails")
    public String showDetails(@RequestParam("breedId") int breedId, Model model) {
		Team10BreedList targetBreed = team10service.getBreedByBreedId(breedId);	
		model.addAttribute("breed", targetBreed);
		return "team10/Team10BreedList_details";
	}
	
}
