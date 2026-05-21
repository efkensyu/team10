package com.example.demo.team10.petregister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.repositories.Team10PetRegisterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team10PetRegisterService {
	private final Team10PetRegisterRepository repository;

	public void saveTeam10PetRegister(Team10PetRegister pet) {
		repository.insertTeam10PetRegister(pet);
	}

	public List<Team10PetRegister> getAllTeam10PetRegister() {
		return repository.findAll();
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