package app.configs;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?> [] getRootConfigClasses() {
    return new Class[] {
      JpaDataConfig.class
    };
  }

  @Override
  protected Class<?> [] getServletConfigClasses() {
    return new Class[] {
      WebMvcConfig.class
    };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {
      "/"
    };
  }

  /* implements WebApplicationInitializer
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.register(SpringConfig.class);
    webContext.setServletContext(servletContext);
    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
    servlet.setLoadOnStartup(1);
    servlet.addMapping("/");
  }*/
}

