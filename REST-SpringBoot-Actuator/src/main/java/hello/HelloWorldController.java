package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/*
    In Spring, REST endpoints are just Spring MVC controllers.
    The following Spring MVC controller handles a GET request for
    /hello-world and returns the Greeting resource:
 */

// @RestController?
@RestController
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // PostMapping
    // PutMapping ...
    @GetMapping("/hello-world") // == @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    /*
        The @ResponseBody annotation tells Spring MVC not to render a model
        into a view, but rather to write the returned object into the response
        body. It does this by using one of Spring’s message converters.
        Because Jackson 2 is in the classpath, this means that
        MappingJackson2HttpMessageConverter will handle the conversion of
        Greeting to JSON if the request’s Accept header specifies that JSON should be returned.
     */
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}
