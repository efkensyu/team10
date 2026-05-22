package com.example.demo.team10.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
	private Integer breedId;
	private String petImage;
	private String petPass;
	private String gender;
	private LocalDate birthday;
	private String memo;
	
	@Transient
	private String breedName; // 一時的に犬種名を入れる箱
}
