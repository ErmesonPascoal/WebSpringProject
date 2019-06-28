package com.ufc.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ufc.br.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImplementacao userDetaisServiceImple;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/").permitAll()
		.antMatchers("/pratos").permitAll()
		.antMatchers("/cadastrarse").permitAll()
		.antMatchers("/cadastrarse/salvarUsuario").permitAll()
		.antMatchers("/listarUsuarios").hasRole("GERENTE")
		.antMatchers("/deletarUsuario/{id}").hasRole("GERENTE")
		.antMatchers("/alterarUsuario/{id}").hasRole("GERENTE")
		.antMatchers("/cadastrarPratos").hasRole("GERENTE")
		.antMatchers("/deletarPratos/{idPrato}").hasRole("GERENTE")
		.antMatchers("/alterarPratos/{idPrato}").hasRole("GERENTE")
		.antMatchers("/cadastrarPratos/salvarPrato").hasRole("GERENTE")
		.antMatchers("/addPratoNaLista/{id}").hasRole("CLIENTE")
		.antMatchers("/addPedido").hasRole("CLIENTE")
		.antMatchers("/deletarPratoDaLista/{idPrato}").hasRole("CLIENTE")
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/logar").successForwardUrl("/pratos")
		.permitAll()
		
		//.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		.and()
		.logout()
		.logoutSuccessUrl("/logar?logout")
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetaisServiceImple).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**","/img/**", "/images/**");
	}


}
