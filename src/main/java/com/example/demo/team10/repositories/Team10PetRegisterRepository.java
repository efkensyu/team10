package com.example.demo.team10.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team10.entity.Team10PetRegister;

@Repository
public interface Team10PetRegisterRepository extends JpaRepository<Team10PetRegister,String>{
	List<Team10PetRegister> findAll();
	
}
