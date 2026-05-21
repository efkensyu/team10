package com.example.demo.team10.petregister;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team10.entity.Team10PetRegister;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetRegisterController {
private final Team10PetRegisterService service;

	@GetMapping("/register")			
	public String index (Model model) {
		//List<Team10PetRegister> userDataList = repository.findAll();
		//model.addAttribute("userDataList", userDataList);
		return "team10/petregister/Team10PetRegisterIn";
	}
	
	@PostMapping("/register")
	public String register (Team10PetRegister pet, Model model) {
		//リポジトリ実行
		service.saveTeam10PetRegister(pet);
		List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();
		
		model.addAttribute("DataList", DataList);
		return "team10/petregister/Team10PetRegisterOut";
	}
}