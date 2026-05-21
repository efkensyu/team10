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
	@Id
	//自動連番用
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	private String petName;
//	private String breedId;
//	private String gender;
//	private Integer birthday;
//	private String memo;
}
