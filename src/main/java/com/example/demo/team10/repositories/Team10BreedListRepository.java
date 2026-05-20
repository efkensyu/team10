package com.example.demo.team10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team10.entity.Team10BreedList;

@Repository
public interface Team10BreedListRepository extends JpaRepository<Team10BreedList,String>{
//	List<Team10BreedList> findAll();
//	
//	List<Team10BreedList> findByBreed_NameContaining(String breedId);
//	
//	List<Team10BreedList> findBySizeId(String sizeId);
	
	
}
