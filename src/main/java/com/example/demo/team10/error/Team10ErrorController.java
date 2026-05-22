package com.example.demo.team10.error;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class Team10ErrorController {
	@ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request, Model model) {
        String errorId = "ERR-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        		+ "-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        model.addAttribute("errorId", errorId);
        model.addAttribute("errorMessage", e.getMessage());
        
     // ステータスコードを追加
        if (e instanceof ResponseStatusException) {
            model.addAttribute("status", ((ResponseStatusException) e).getStatusCode().value());
        } else {
            model.addAttribute("status", 500);
        }
        
        return "/team10/Team10Error";  // → templates/error.html へ
    }
}
