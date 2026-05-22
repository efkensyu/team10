package com.example.demo.team10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team10.entity.Team10PetRegister;

@Repository
public interface Team10PetRegisterRepository extends JpaRepository<Team10PetRegister, Integer>{
	default void insertTeam10PetRegister(Team10PetRegister pet) {
		this.save(pet);
	}
	//public List<Team10PetRegister> findByPET_NAME(String name);
}
