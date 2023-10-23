package com.luanvan.b1910025.security;

import com.luanvan.b1910025.security.jwt.AuthEntryPointJwt;
import com.luanvan.b1910025.security.jwt.AuthTokenFilter;
import com.luanvan.b1910025.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.BeanIds;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(
         securedEnabled = true,
         jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl customUserDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter jwtAuthenticationFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                .permitAll()
                .antMatchers("/api/auth/**")
                .permitAll()
//                .antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
//                .permitAll()
                .antMatchers(HttpMethod.GET,
                        "/api/admin/**",
                        "/api/users/**",
                        "/api/tour/**",
                        "/api/dia-chi/**",
                        "/api/loai-tour/**",
                        "/api/hanh-khach/**",
                        "/api/diem-den/**",
                        "/api/booking/**",
                        "/api/search/**",
                        "/api/hoa-don/**",
                        "/api/thanh-toan/**"
                        )
                .permitAll()
                .anyRequest()
                .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }


































//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }
//
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//   /* @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api/tour/**").permitAll()
//                .antMatchers("/api/dia-chi/**").permitAll()
//                .antMatchers("/api/loai-tour/**").permitAll()
//                .antMatchers("/api/hanh-khach/**").permitAll()
//                .antMatchers("/api/diem-den/**").permitAll()
//                .antMatchers("/api/booking/**").permitAll()
//                .antMatchers("/api/khach-san/**").permitAll()
//                .antMatchers("/api/search/**").permitAll()
//                .antMatchers("/api/hoa-don/**").permitAll()
//                .antMatchers("/api/thanh-toan/**").permitAll()
//                .antMatchers("/api/admin/**").permitAll()
//                .anyRequest().authenticated();
//
//        http.authenticationProvider(authenticationProvider());
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }*/
//   @Bean
//   public CorsConfigurationSource corsConfigurationSource() {
//       CorsConfiguration configuration = new CorsConfiguration();
//       configuration.setAllowedOrigins(Arrays.asList("allowedOriginPatterns")); // Có thể chỉ định các origin cụ thể
//       configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//       configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
//       configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
//       configuration.setAllowCredentials(true);
//
//       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//       source.registerCorsConfiguration("/**", configuration);
//       return source;
//   }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .cors().configurationSource(corsConfigurationSource()).and()
//                .csrf().disable()
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .antMatchers("/api/tour/**", "/api/dia-chi/**", "/api/loai-tour/**", "/api/hanh-khach/**",
//                                        "/api/diem-den/**", "/api/booking/**", "/api/khach-san/**", "/api/search/**",
//                                        "/api/hoa-don/**", "/api/thanh-toan/**", "/api/admin/**")
//                                .permitAll()
//                                .anyRequest().authenticated()
//                );
//
//        // ... các phần cấu hình khác ...
//
//        return http.build();
//    }
//    /*@Component
//    public class CorsFilter extends OncePerRequestFilter{
//
//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Methods", "GET, POST,PUT, DELETE, OPTIONS");
//            response.setHeader("Access-Control-Max-Age", "3600");
//            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
//            response.setHeader("Access-Control-Expose-Headers", "xsrf-token");
//            if("OPTIONS".equals(request.getMethod())){
//                response.setStatus(HttpServletResponse.SC_OK);
//            }
//            else{
//                filterChain.doFilter(request, response);
//            }
//        }
//    }*/
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf()
//                .disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(unauthorizedHandler)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/",
//                        "/favicon.ico",
//                        "/**/*.png",
//                        "/**/*.gif",
//                        "/**/*.svg",
//                        "/**/*.jpg",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js")
//                .permitAll()
//                .antMatchers("/api/auth/**")
//                .permitAll()
//                .antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
//                .permitAll()
//                .antMatchers(HttpMethod.GET, "/api/polls/**", "/api/users/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//
//        // Add our custom JWT security filter
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//    }

////  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//
//      http
//      .authorizeRequests()
//          .anyRequest().hasRole("USER")
//          .and().formLogin().and()
//      .httpBasic()
//      .and()
//      .logout()
//      .logoutUrl("/j_spring_security_logout")
//      .logoutSuccessUrl("/")
//      ;
//  }
}