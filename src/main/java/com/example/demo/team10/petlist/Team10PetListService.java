package com.example.demo.team10.petlist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.team10.entity.Team10BreedList;
import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.repositories.Team10BreedListRepository;
import com.example.demo.team10.repositories.Team10PetRegisterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team10PetListService {
    private final Team10PetRegisterRepository repository;
    private final Team10BreedListRepository breedRepository;

    public void saveTeam10PetRegister(Team10PetRegister pet) {
        repository.insertTeam10PetRegister(pet);
    }

    public List<Team10PetRegister> getAllTeam10PetRegister() {
        List<Team10PetRegister> dataList = repository.findAll();
        for (Team10PetRegister p : dataList) {
            if (p.getBreedId() != null) {
                Team10BreedList breed = breedRepository.getBreedByBreedId(p.getBreedId());
                if (breed != null) {
                    p.setBreedName(breed.getBreedName());
                }
            }
        }
        return dataList;
    }

    public Team10PetRegister getPetById(int petId) {
        Team10PetRegister pet = repository.findById(petId).orElse(null);
        if (pet != null && pet.getBreedId() != null) {
            Team10BreedList breed = breedRepository.getBreedByBreedId(pet.getBreedId());
            if (breed != null) {
                pet.setBreedName(breed.getBreedName());
            }
        }
        return pet;
    }

    public String saveImage(MultipartFile imageFile) throws IOException {
        String originalFilename = imageFile.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "_" + originalFilename;
        Path uploadPath = Paths.get("src/main/resources/static/team10/petimages/");
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }
    
    public void deletePetById(int petId) {
        repository.deleteById(petId);
    }
}