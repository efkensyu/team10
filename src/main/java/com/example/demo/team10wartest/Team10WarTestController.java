package com.example.demo.team10wartest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.team10.entity.Team10Size;
import com.example.demo.team10.repositories.Team10SizeRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team10WarTestController {
	private final Team10SizeRepository sizeRepository;

    @GetMapping("/war-test")
    public String warTestPage() {
        return "team10/Team10WarTest";
    }

    @GetMapping("/db-test")
    @ResponseBody
    public String dbTest() {
        try {
            long count = sizeRepository.count();
            return "DB接続OK size_tblの件数：" + count;
        } catch (Exception e) {
            e.printStackTrace();
            return "DB接続NG：" + e.getClass().getName() + "<br>" + e.getMessage();
        }
    }

    @GetMapping("/db-insert-test")
    @ResponseBody
    public String dbInsertTest() {
        try {
            Team10Size size = new Team10Size();
            size.setSize_id("tes");
            size.setSize_name("テスト");

            sizeRepository.save(size);

            long count = sizeRepository.count();

            return "DB登録OK size_tblの件数：" + count;
        } catch (Exception e) {
            e.printStackTrace();
            return "DB登録NG：" + e.getClass().getName() + "<br>" + e.getMessage();
        }
    }
}
