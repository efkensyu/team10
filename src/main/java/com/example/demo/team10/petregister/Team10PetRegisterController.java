package com.example.demo.team10.petregister;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.team10.entity.Team10BreedList;
import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.repositories.Team10BreedListRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetRegisterController {
	private final Team10PetRegisterService service;
	private final Team10BreedListRepository breedRepository;
	

	@GetMapping("/team10/petregister")
	public String index(Model model) {
		List<Team10BreedList> breedList = breedRepository.findAll();
		model.addAttribute("breedList", breedList);
		return "team10/petregister/Team10PetRegisterIn";
	}

	@PostMapping("/team10/petregister")
	public String register(Team10PetRegister pet, @RequestParam("imageFile") MultipartFile imageFile, Model model)
			throws IOException {
		if (!imageFile.isEmpty()) {
			String fileName = service.saveImage(imageFile);
			pet.setPetImage(fileName);
		}
		//ダミーパスワード
		pet.setPetPass("dummy_password");
		//リポジトリ実行
		service.saveTeam10PetRegister(pet);
		List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();

		model.addAttribute("DataList", DataList);
		return "team10/petregister/Team10PetRegisterOut";
	}
}