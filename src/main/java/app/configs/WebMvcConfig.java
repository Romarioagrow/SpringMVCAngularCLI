package app.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.*;


@EnableWebMvc
@ComponentScan(basePackages = {"app"})
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("index.html");
    registry.addViewController("/login").setViewName("index.html");
  }


  /*...CORS*/
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/").allowedOrigins("http://localhost:8080");
    registry.addMapping("/").allowedOrigins("http://localhost:4200");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

}
