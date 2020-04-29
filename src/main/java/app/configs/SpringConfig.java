package app.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.*;


@EnableWebMvc
@ComponentScan(basePackages = {"app.controllers", "app.repos", "app.services"})
@EnableJpaRepositories(basePackages = "app.repos", entityManagerFactoryRef = "emf")
//@EnableConfigurationProperties
public class SpringConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
  }

  /*...*/
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/").allowedOrigins("http://localhost:8080");
    registry.addMapping("/").allowedOrigins("http://localhost:4200");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }





  /*DB Config*/

  /*@Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
      .generateUniqueName(false)
      .setName("products")
      .setType(EmbeddedDatabaseType.H2)
      .addDefaultScripts()
      .setScriptEncoding("UTF-8")
      .ignoreFailedDrops(true)
      .build();
  }

  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  @Bean(name="emf")
  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {

      try {
        // Create registry
        registry = new StandardServiceRegistryBuilder().configure().build();
        // Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);
        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();

      } catch (Exception e) {
        e.printStackTrace();
        if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
      }
    }
    return sessionFactory;
  }

  public static void shutdown() {
    if (registry != null) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }*/


}
