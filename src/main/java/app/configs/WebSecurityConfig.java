package app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private final SecurityAuthenticationProvider authProvider;

  @Autowired
  public WebSecurityConfig(SecurityAuthenticationProvider authProvider) {
    this.authProvider = authProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .authorizeRequests()
        .antMatchers("/admin").hasAuthority("ADMIN")
        .antMatchers("/user").authenticated()
        .anyRequest().permitAll()
      .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        /*.loginProcessingUrl("/login/process")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/", true)*/
      .and()
        .logout()
        .permitAll()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
      .and().csrf().disable();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder(8);
  }

  @Bean(name = "mvcHandlerMappingIntrospector")
  public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
    return new HandlerMappingIntrospector();
  }

}
