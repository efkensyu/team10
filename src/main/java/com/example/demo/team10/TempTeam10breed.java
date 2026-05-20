package com.example.demo.team10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "breed_tbl")
@Data
public class TempTeam10breed {
	@Id
	private String breed_id;
	private String breed_name;
	private String size_id;
	private String feature;
	private String description;
}
