package app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


//@ComponentScan
public class WebServletConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(SpringConfig.class);
        webContext.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

  /*@Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerCustomizer() {
    return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index.html"));
  }*/

}

 /*
    Следующая задача: сервлеты
    на спринге мини инет-магазин с простейшим функционалом отображения товаров у которых есть цена и название
    Т.е. реестр всех товаров + открытие отдельного товара по ссылке
    Всё это дело нужно мавеном заворачивать сервлет
    Запуск делать на глассфише
    база H2 embedded
    Главная цель - потренироваться писать и конфигурировать сервлет, так-же тренировка спринга, практика работы с глассфишом
    */


/*1.V package WAR файл
 * 2.V deploy war to glassfish
 * 3.V servlet mapping
 * 4. angular front
 * */
