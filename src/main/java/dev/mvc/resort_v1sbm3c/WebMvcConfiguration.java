package dev.mvc.resort_v1sbm3c;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dev.mvc.contents.Contents;
import dev.mvc.tool.Tool;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Windows: path = "C:/kd/deploy/resort_v2sbm3c_blog/contents/storage";
        // ▶ file:///C:/kd/deploy/resort_v2sbm3c_blog/contents/storage
      
        // Ubuntu: path = "/home/ubuntu/deploy/resort_v2sbm3c_blog/contents/storage";
        // ▶ file:////home/ubuntu/deploy/resort_v2sbm3c_blog/contents/storage
      
        // 인식되는 경로: http://localhost:9091/contents/storage";
        registry.addResourceHandler("/contents/storage/**").addResourceLocations("file:///" +  Contents.getUploadDir());
        
        // 인식되는 경로: http://localhost:9091/qcontents/storage";
        // registry.addResourceHandler("/qcontents/storage/**").addResourceLocations("file:///" +  Qcontents.getUploadDir());
        
        // 인식되는 경로: http://localhost:9091/member/storage";
        // registry.addResourceHandler("/member/storage/**").addResourceLocations("file:///" +  Member.getUploadDir());
    }

    // .allowedOrigins("http://localhost:3000") // React 앱의 URL 만 허용
    // .allowedOriginPatterns("*"): 모든 도메인 허가
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                   .allowedOriginPatterns("*")
                   .allowedMethods("GET", "POST", "PUT", "DELETE")
                   .allowedHeaders("*")
                   .allowCredentials(true);
    }  
    
}




