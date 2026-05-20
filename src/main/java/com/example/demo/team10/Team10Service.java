package com.example.demo.team10;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team10.entity.Team10BreedList;
import com.example.demo.team10.repositories.Team10BreedListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class Team10Service {

	private final Team10BreedListRepository breedlistrepository;
	
	public List<Team10BreedList> findAll() {
	    return breedlistrepository.findAll();
	}

}
