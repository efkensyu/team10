package com.example.demo.team10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team10.entity.Team10Size;

@Repository
public interface Team10SizeRepository extends JpaRepository<Team10Size,String>{
	
}
