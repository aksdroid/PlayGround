package edu.aksdroid.play.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.aksdroid.play.model.Player;

@RestController
public class PlayController {

    private static final String template = "Heēāllo, %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/playit")
    public Player playIt(@RequestParam(value="name", defaultValue="World") String name) {
        return new Player(counter.incrementAndGet(),
                            String.format(template, name));
    }
}