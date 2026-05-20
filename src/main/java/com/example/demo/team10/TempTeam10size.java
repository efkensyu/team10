package com.example.demo.team10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "size_tbl")
@Data
public class TempTeam10size {
	@Id
	private String size_id;
	private String size_name;
}
