package com.example.demo.team10;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team10.entity.Team10BreedList;

import lombok.RequiredArgsConstructor;

@Controller	
@RequiredArgsConstructor	

public class Team10TopController {
	private final Team10Service team10service;
	
		
	@GetMapping("/team10/top")			
	public String index () {					
		return "team10/Team10Top";		
	}
	
	//犬種一覧ボタンの処理
	@PostMapping(value="/team10/breedlist",params="breedlist")
	public String send1(Model model) {
		List<Team10BreedList> breeds = team10service.findAll();
		model.addAttribute("breeds", breeds);
		return "team10/Team10BreedList";
	}
	
	//遷移先からトップに戻るボタンの処理
	@GetMapping("/team10/main") 
	public String showTopPage() {
	    return "team10/Team10Top"; 
	}
	
//	@PostMapping(value = "/team10/breedlist", params = "breedlistdetails")
//	public String showBreedDetail(@RequestParam("breedId") int breedId, Model model) {
//	    // breedIdを使って詳細情報を取得する処理
//	    Team10BreedList breed = team10service.getBreedByBreedId(breedId);
//	    model.addAttribute("breed", breed);
//	    return "team10/Team10BreedList_Details"; // 遷移先のテンプレート名
//	}
	/*これを遷移先のHTMLに書くとTOPに戻ってこれる
	 * <form method="get" th:action="@{/team10/main}">
		<input type="submit" value="トップへ戻る" />
	</form>*/
	
	
	//登録ボタンの処理
	@PostMapping(value="/team10/petregister",params="petregister")
	public String send2(Model model) {
		return "team10/petregister/Team10PetRegisterIn";
	}
	
	//ペット一覧ボタンの処理
	/*@GetMapping(value="/team10/petlist",params="petlist")
	public String send3(Model model) {
		List<Team10BreedList> breeds = team10service.findAll();
		model.addAttribute("petlist", petlist);
		return "team10/Team10PetList";
	}*/			
}
