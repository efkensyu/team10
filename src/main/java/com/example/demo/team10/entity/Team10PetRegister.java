package com.example.demo.team10.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "team10_pets_tbl")
@Data
public class Team10PetRegister {	
	@Id
	//自動連番用
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;

    @NotBlank(message = "ペットの名前を入力してください")
    @Size(max = 100, message = "名前は100文字以内で入力してください")
    private String petName;

    private Integer breedId;

    private String petImage;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 4, max = 255, message = "パスワードは4文字以上255文字以内で入力してください")
    private String petPass;

    @NotBlank(message = "性別を選択してください")
    private String gender;

    @PastOrPresent(message = "誕生日に未来の日付は設定できません")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Size(max = 1000, message = "メモは1000文字以内で入力してください")
    private String memo;
    
    @Transient
	private String breedName; // 一時的に犬種名を入れる箱
}
