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
	private String breed_id;
	private String breed_name;
	@Lob
	private byte[] breed_image;
	private String size_id;
	private String feature;
	private String description;
}
