package com.example.demo.team10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "breed_tbl")
@Data
public class Team10BreedList {
	@Id
	private int breedId;
	private String breedName;
	@Lob
	private byte[] breedImage;
	private Integer sizeId;
	private String feature;
}
