package com.example.demo.team10.petlist;

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
import com.example.demo.team10.repositories.Team10BreedListRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetListController {
    private final Team10PetListService service;
    private final Team10BreedListRepository breedRepository;

    @GetMapping("/team10/petlist")
    public String list(Model model) {
        List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();
        model.addAttribute("DataList", DataList);
        return "/team10/petlist/Team10PetList";
    }

    @PostMapping("/team10/petlist/details")
    public String details(@RequestParam("petId") int petId, Model model) {
        Team10PetRegister pet = service.getPetById(petId);
        model.addAttribute("pet", pet);
        return "/team10/petlist/Team10PetListDetails";
    }

    @PostMapping("/team10/peteditor")
    public String editAuth(@RequestParam("petId") int petId,
                           @RequestParam("petPass") String petPass,
                           Model model) {
        Team10PetRegister pet = service.getPetById(petId);
        if (pet == null || !pet.getPetPass().equals(petPass)) {
            model.addAttribute("error", "パスワードが違います");
            model.addAttribute("pet", pet);
            return "/team10/petlist/Team10PetListDetails";
        }
        List<Team10BreedList> breedList = breedRepository.findAll();
        model.addAttribute("pet", pet);
        model.addAttribute("breedList", breedList);
        return "/team10/petlist/Team10Pet";
    }

    @PostMapping("/team10/peteditor")
    public String edit(@ModelAttribute("pet") Team10PetRegister pet,
                       @RequestParam("imageFile") MultipartFile imageFile,
                       Model model) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = service.saveImage(imageFile);
            pet.setPetImage(fileName);
        }
        service.saveTeam10PetRegister(pet);
        return "/team10/petlist/Team10PetList";
    }
}