package com.star.starry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**") // 对所有路径应用 CORS 配置
                  .allowedOrigins("http://localhost:5173") // 允许来自这些源的请求(前端)
                  .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的 HTTP 方法
                  .allowedHeaders("*") // 允许所有请求头
                  .allowCredentials(true) // 允许发送认证信息（如 cookie、HTTP 认证）
                  .maxAge(3600); // 预检请求的缓存时间（秒），在此期间无需再发送预检请求
      }
}
