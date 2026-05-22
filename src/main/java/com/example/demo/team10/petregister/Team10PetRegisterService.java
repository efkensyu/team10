package com.example.demo.team10.petregister;

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

	public String saveImage(MultipartFile imageFile) throws IOException {
		//  元のファイル名を取得
		String originalFilename = imageFile.getOriginalFilename();
		// リネーム
		String fileName = System.currentTimeMillis() + "_" + originalFilename;
		// 保存フォルダの指定
		Path uploadPath = Paths.get("src/main/resources/static/team10/petimages/");

		// 決めたファイル名で画像を保存する
		Path filePath = uploadPath.resolve(fileName);
		Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		// 作ったファイル名を返す
		return fileName;
	}
}