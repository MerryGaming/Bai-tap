package org.aibles.login2.configuration;

import org.aibles.login2.service.impl.AuthenticationUserDetailService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final AuthenticationUserDetailService authenticationUserDetailService;

  public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder,
      AuthenticationUserDetailService authenticationUserDetailService) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.authenticationUserDetailService = authenticationUserDetailService;
  }

  @Override protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
  }
}
