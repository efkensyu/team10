package com.example.demo.team10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Team10SizeRepository extends JpaRepository<size,String>{
	
}
