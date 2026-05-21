package com.example.demo.team10.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team10.entity.Team10BreedList;

@Repository
public interface Team10BreedListRepository extends JpaRepository<Team10BreedList,Integer>{

	List<Team10BreedList> findAll();
	
	Team10BreedList getBreedByBreedId(Integer breedId);
	
	//List<Team10BreedList> findBySizeId(String sizeId);

	
	
}
