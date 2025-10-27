@Configueration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecuriyFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cstf(csrf -> csrf.disable())
                .authorizeHttpRequests(autr -> auth
                        .requestMatchers("/login", "./signup").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
