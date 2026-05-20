package com.example.demo.team10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "register_tbl")
@Data
public class Team10petRegister {
	@Id
	private String pet_id;
	private String pet_name;
	private String breed_id;
	private String gender;
	private Integer birthday;
	private String memo;
}
