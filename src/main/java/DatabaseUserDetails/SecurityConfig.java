package DatabaseUserDetails;

import org.pizzeria.italy.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.GET, "/user", "/user/**").hasAuthority("USER")
				.requestMatchers(HttpMethod.POST, "/user", "/user/**").hasAuthority("ADMIN")
				.requestMatchers("/admin", "/admin/**").hasAuthority("ADMIN")
				.requestMatchers("/useradmin", "/useradmin/**").hasAnyAuthority("USER", "ADMIN")	
				.requestMatchers("/**").permitAll()
			.and().formLogin()
			.and().logout()
		;

		return http.build();
	}
	
	@Bean
	public UserService getuseDetailsService() {
		
		return new UserService();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(getuseDetailsService());
		provider.setPasswordEncoder(getPasswordEncoder());
		
		return provider;
	}
}	
