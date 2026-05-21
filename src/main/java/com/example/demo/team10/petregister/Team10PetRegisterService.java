package com.example.demo.team10.petregister;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public List<Team10PetRegister> getAllTeam10PetRegister(){
		return repository.findAll();
	}
}