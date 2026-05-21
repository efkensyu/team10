package com.example.demo.team10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "register_tbl")
@Data
public class Team10PetRegister {
	@Id
	private String pet_id;
	private String pet_name;
	private String breed_id;
	@Lob
	private byte[] pet_image;
	private String pet_pass;
	private String gender;
	private Integer birthday;
	private String memo;
}
