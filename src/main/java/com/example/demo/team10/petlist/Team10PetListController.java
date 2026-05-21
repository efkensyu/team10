package com.example.demo.team10.petlist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.repositories.Team10PetRegisterRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetListController {
	private final Team10PetRegisterRepository petRegisterRepository;
	
	@GetMapping("/petlist")			
	public String index(Model model) {
	    System.out.println("petlistにアクセスされました");

	    System.out.println("findAll前");
	    List<Team10PetRegister> petList = petRegisterRepository.findAll();
	    System.out.println("findAll後");
	    System.out.println("取得件数：" + petList.size());

	    model.addAttribute("petList", petList);

	    return "team10/petlist/Team10PetList";	
	}
}
