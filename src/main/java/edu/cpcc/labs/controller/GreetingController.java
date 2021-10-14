package edu.cpcc.labs.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cpcc.labs.model.Greeting;


@RestController
public class GreetingController {

	private static final String template = "Greetings, %s!";
    private final AtomicLong counter = new AtomicLong(); // stateful counter...

    @GetMapping("/api/greetings/greeting")
    // Example: /api/greetings/greeting?name=john
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {   	
    	
    	Greeting greeting = null;
		// the counter value odd (i.e. 1, 3, 5, 7, ...)
        long newCounter = 0; //initialize
        // newCounter = counter.get() * counter.incrementAndGet();
        newCounter = counter.incrementAndGet();
        if (newCounter % 2 != 0) {
        	// an odd number greeting...display it....don't display even numbered greetings...
        	String templateWithName = String.format(template, name);
        	greeting = new Greeting(newCounter, templateWithName);
        	System.out.println(greeting.toString());
        }
        return greeting;
    }
	
}
