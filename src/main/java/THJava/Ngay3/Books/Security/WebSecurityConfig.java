package THJava.Ngay3.Books.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import THJava.Ngay3.Books.Services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	String arrPermitAll[]= new String[] {"/webjars/**","/","/verify"};
	@Bean
	protected BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}


	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("filter");
		http.authorizeHttpRequests(requests -> requests
				.antMatchers(arrPermitAll).permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/process_register").permitAll()
				.antMatchers("/users/**").permitAll()
				.antMatchers("/forgot_password").permitAll()
				.antMatchers("/reset_password").permitAll()
				.antMatchers("/API/**").permitAll()
				.antMatchers("/books/").hasAnyAuthority("USER", "CREATER", "EDITOR", "ADMIN")
				.antMatchers("/books/new").hasAnyAuthority("ADMIN", "CREATER")
				.antMatchers("/books/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
				.antMatchers("/books/delete/**")
				.hasAuthority("ADMIN").anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").permitAll()).logout(logout -> logout.permitAll())
				.exceptionHandling(handling -> handling.accessDeniedPage("/403")).csrf().disable();
		return http.build();
	}

}
