package com.example.demo.team10.petlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;   // ← 追加
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team10.entity.Team10PetRegister;
import com.example.demo.team10.repositories.Team10BreedListRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10PetListController {
    private final Team10PetListService service;
    private final Team10BreedListRepository breedRepository;

    @Value("${team10.admin.password}")   // ← 追加：設定ファイルから読み込む
    private String adminPassword;

    @GetMapping("/team10/petlist")
    public String list(Model model) {
        List<Team10PetRegister> DataList = service.getAllTeam10PetRegister();
        model.addAttribute("DataList", DataList);
        return "team10/petlist/Team10PetList";
    }

    @PostMapping("/team10/petlist/details")
    public String details(@RequestParam("petId") int petId, Model model) {
        Team10PetRegister pet = service.getPetById(petId);
        model.addAttribute("pet", pet);
        return "team10/petlist/Team10PetListDetails";
    }

    @PostMapping("/team10/peteditor/auth")
    public String editAuth(@RequestParam("petId") int petId,
                           @RequestParam("petPass") String petPass,
                           @RequestParam("action") String action,
                           Model model) {
        Team10PetRegister pet = service.getPetById(petId);

        // 空欄でエラー
        if (petPass == null || petPass.isEmpty()) {
            model.addAttribute("pet", pet);
            model.addAttribute("passError", "パスワードを入力してください");
            return "team10/petlist/Team10PetListDetails";
        }

        // ★ 管理者パスワード or 個別パスワードのどちらかが合っていればOK
        boolean isAdmin = adminPassword.equals(petPass);
        boolean isPetPassCorrect = pet.getPetPass().equals(petPass);

        if (!isAdmin && !isPetPassCorrect) {
            model.addAttribute("pet", pet);
            model.addAttribute("passError", "パスワードが違います");
            return "team10/petlist/Team10PetListDetails";
        }

        // 削除
        if ("削除する".equals(action)) {
            service.deletePetById(petId);
            return "redirect:/team10/petlist";
        }

        // OK → 編集画面へ
        return "redirect:/team10/petlisteditor?petId=" + petId;
    }
}