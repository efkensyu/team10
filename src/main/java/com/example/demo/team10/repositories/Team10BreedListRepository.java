package com.example.demo.team10.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Team10BreedListRepository extends JpaRepository<breed,String>{
	List<breed> findAll();
	
	List<breed> findByBreedNameContaining(String breedId);
	
	List<breed> findBySizeId(String sizeId);
	
	
}
