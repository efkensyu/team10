package com.example.demo.team10.petregister;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
public class Team10PetRegisterController {
    private final Team10PetRegisterService service;
    private final Team10BreedListRepository breedRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(LocalDate.parse(text));
                } catch (Exception e) {
                    setValue(null);
                }
            }
        });
    }

    @GetMapping("/team10/petregister")
    public String index(Model model) {
        List<Team10BreedList> breedList = breedRepository.findAll();
        model.addAttribute("breedList", breedList);
        Team10PetRegister initPet = new Team10PetRegister();
        initPet.setGender("オス");
        initPet.setPetName("ポチ");
        model.addAttribute("team10PetRegister", initPet);
        return "team10/petregister/Team10PetRegisterIn";
    }

    @PostMapping("/team10/petregister")
    public String register(
            @Validated @ModelAttribute("team10PetRegister") Team10PetRegister pet,
            BindingResult result,
            @RequestParam("imageFile") MultipartFile imageFile,
            Model model) throws IOException {

        // 日付が無効な場合（nullになった場合）にエラーを追加
        if (pet.getBirthday() == null && !result.hasFieldErrors("birthday")) {
            result.addError(new FieldError("team10PetRegister", "birthday", "正しい日付を入力してください"));
        }

        if (result.hasErrors()) {
            List<Team10BreedList> breedList = breedRepository.findAll();
            model.addAttribute("breedList", breedList);
            return "team10/petregister/Team10PetRegisterIn";
        }
        if (!imageFile.isEmpty()) {
            String fileName = service.saveImage(imageFile);
            pet.setPetImage(fileName);
        }
        service.saveTeam10PetRegister(pet);
        List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();
        model.addAttribute("DataList", DataList);
        return "team10/petregister/Team10PetRegisterOut";
    }
}

