package com.example.demo.team10.peteditor;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.team10.entity.Team10BreedList;
import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.petlist.Team10PetListService;
import com.example.demo.team10.repositories.Team10BreedListRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetEditorController {
    private final Team10PetListService service;
    private final Team10BreedListRepository breedRepository;

 // 編集画面表示
    @GetMapping("/team10/petlisteditor")
    public String editForm(@RequestParam("petId") int petId, Model model) {
        Team10PetRegister pet = service.getPetById(petId);
        List<Team10BreedList> breedList = breedRepository.findAll();
        model.addAttribute("pet", pet);
        model.addAttribute("breedList", breedList);
        return "team10/petlist/Team10PetListEditor";  // ← 修正
    }

    @PostMapping("/team10/petlisteditor")
    public String edit(@ModelAttribute("pet") Team10PetRegister pet,
                       @RequestParam("imageOption") String imageOption,
                       @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                       Model model) throws IOException {
    	
    	Team10PetRegister original = service.getPetById(pet.getPetId());
    pet.setPetPass(original.getPetPass());

    	if ("new".equals(imageOption) && imageFile != null && !imageFile.isEmpty()) {
            String fileName = service.saveImage(imageFile);
            pet.setPetImage(fileName);
        }

        service.saveTeam10PetRegister(pet);
        return "redirect:/team10/petlist";

    }
}