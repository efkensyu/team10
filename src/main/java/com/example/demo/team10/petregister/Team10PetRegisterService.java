package com.example.demo.team10.petregister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.team10.entity.Team10BreedList;
import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.repositories.Team10BreedListRepository;
import com.example.demo.team10.repositories.Team10PetRegisterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team10PetRegisterService {
	private final Team10PetRegisterRepository repository;
	private final Team10BreedListRepository breedRepository;

	public void saveTeam10PetRegister(Team10PetRegister pet) {
		repository.insertTeam10PetRegister(pet);
	}

	public List<Team10PetRegister> getAllTeam10PetRegister() {
		// ペット一覧を全件取る
		List<Team10PetRegister> dataList = repository.findAll();

		// 犬種IDを元に犬種名をセットする
		for (Team10PetRegister p : dataList) {
			if (p.getBreedId() != null) {
				Team10BreedList breed = breedRepository.getBreedByBreedId(p.getBreedId());
				if (breed != null) {
					p.setBreedName(breed.getBreedName());
				}
			}
		}

		// 犬種名も詰まった状態のリストを返す
		return dataList;
	}
	
	@Value("${team10.upload.dir}")
    private String uploadDir;
	
	// 起動時に保存ディレクトリを自動作成
    @PostConstruct
    public void init() throws IOException {
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

	public String saveImage(MultipartFile imageFile) throws IOException {
        String originalFilename = imageFile.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "_" + originalFilename;

        // 設定ファイルから読んだパスを使う
        Path uploadPath = Paths.get(uploadDir);
        Path filePath = uploadPath.resolve(fileName);

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
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
}