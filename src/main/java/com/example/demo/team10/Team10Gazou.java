package com.example.demo.team10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Team10Gazou implements WebMvcConfigurer {

    @Value("${team10.upload.dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/team10/petimages/**")
                .addResourceLocations(
                    "file:" + uploadDir + "/",                   // ① 外部フォルダ（新規アップロード）
                    "classpath:/static/team10/petimages/"        // ② プロジェクト内（既存画像）
                );
    }
}

