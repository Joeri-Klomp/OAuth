package be.vdab.oauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    @Bean
    public SecurityFilterChain geefrechten(HttpSecurity http) throws Exception {
        //We definieren dat we oauth gebruiken (gebruiker zal dus inloggen op een andere website)
        http.oauth2Login();
        //Iedereen heeft toegang tot de beginpagina
        http.authorizeRequests(requests -> requests.mvcMatchers("/").permitAll()
        //Enkel ingelogde gebruikers hebben toegang tot pagina met URL beveiligd
            .mvcMatchers("/beveiligd").authenticated());
        return http.build();
    }
}
