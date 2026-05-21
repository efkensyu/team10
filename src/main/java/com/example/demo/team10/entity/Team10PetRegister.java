package com.example.demo.team10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pets_tbl")
@Data
public class Team10PetRegister {
	
	//自動連番用
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer petId;
	private String petName;
	private String petImage;
//	private String breedId;
	
	//private String petPass;
//	private String gender;
//	private Integer birthday;
//	private String memo;
}
