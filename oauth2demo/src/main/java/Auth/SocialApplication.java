package Auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Sso
@RestController

public class SocialApplication extends WebSecurityConfigurerAdapter {


    /**
     * Spring Boot attaches a special meaning to a WebSecurityConfigurer on the class that
     * carries the @EnableOAuth2Sso annotation: it uses it to configure the security filter
     * chain that carries the OAuth2 authentication processor. So all we need to do to make
     * our home page visible is to explicitly authorizeRequests() to the home page and the
     * static resources it contains (we also include access to the login endpoints which handle
     * the authentication). All other requests (e.g. to the /user endpoint) require authentication.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**", "/error**")
                .permitAll()
                .anyRequest()
                .authenticated()

                /*
                    Spring Security has built in support for a /logout endpoint which will do the right thing for us
                    (clear the session and invalidate the cookie). To configure the endpoint we simply extend the existing
                    configure() method in our WebSecurityConfigurer:
                 */
                .and().logout().logoutSuccessUrl("/").permitAll()

                /*
                    Many JavaScript frameworks have built in support for CSRF (e.g. in Angular they call it XSRF),
                    but it is often implemented in a slightly different way than the out-of-the box behaviour of Spring
                    Security. For instance in Angular the front end would like the server to send it a cookie called
                    "XSRF-TOKEN" and if it sees that, it will send the value back as a header named "X-XSRF-TOKEN".
                    We can implement the same behaviour with our simple jQuery client, and then the server side changes
                    will work with other front end implementations with no or very few changes. To teach Spring Security
                    about this we need to add a filter that creates the cookie and also we need to tell the existing CRSF
                    filter about the header name. In the WebSecurityConfigurer:
                 */
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }


    //Principal?

    @CrossOrigin
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialApplication.class, args);
    }
}
