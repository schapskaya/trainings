package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: Svetlana Chapskaya
 * Date: 16.07.2016
 * Time: 17:44
 * To change this templateName use File | Settings | File Templates.
 */
@RestController
public class GreetingController {
    private static final String templateName = "Hello, %s!";
    private static final String templateSurname = "Hello, %s %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public Greeting greeting(@PathVariable(value="name") String name, @RequestParam(value = "surname", defaultValue = "") String surname) {
        String content =
                (!surname.isEmpty())
                        ? String.format(templateSurname, name, surname)
                        : String.format(templateName, name);
        return new Greeting(counter.incrementAndGet(),
                content);
    }
}
