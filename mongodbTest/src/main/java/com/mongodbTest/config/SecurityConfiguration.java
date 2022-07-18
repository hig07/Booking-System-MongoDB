package com.mongodbTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	//보안 : 인증(Authentication),권한(Authorization-인가,허가), Role-
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> 
            		authz
            		.antMatchers("/", "/board/list", "/sign/signup", "/sign/signin").permitAll()// 인증필요없이 누구나 접근가능
            		.antMatchers("/board/write").hasRole("USER")
            		.antMatchers("/board/write").hasRole("ADMIN")
            		.anyRequest().authenticated()//나머지 요청은 모두 인증하고 접근하여야합니다.:로그인하세요
            		);
       http.formLogin(form -> form
       					.loginPage("/sign/signin")
       					.usernameParameter("email") //Default is "username".
       					.passwordParameter("pass") //Default is "password".
                        .failureUrl("/signin?errMsg")
       					.loginProcessingUrl("/sign/signin") //loginProcessingUrl: form action
                        .defaultSuccessUrl("/")
       					.permitAll()
       );
       http.logout(logout -> logout
    		   .logoutSuccessUrl("/")
    		   .invalidateHttpSession(true)
    		   );
       http.csrf();     
        
       return http.build();
    }

	@Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(
        		"/css/**"
        		,"/js/**"
        		,"/images/**"
        		,"/favicon.ico*"
        		);
    }

}
