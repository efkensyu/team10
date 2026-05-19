package com.example.demo.team10;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface team10petRegisterRepository extends JpaRepository<register,String>{
	List<register> findAll();
	
}
