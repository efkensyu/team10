package com.example.demo.team10;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface team10breedRepository extends JpaRepository<breed,String>{
	List<breed> findAll();
	
	List<breed> findByBreedNameContaining(String breedId);
	
	List<breed> findBySizeId(String sizeId);
	
	
}
