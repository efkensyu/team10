package com.example.demo.team10.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Team10PetRegisterRepository extends JpaRepository<register,String>{
	List<register> findAll();
	
}
