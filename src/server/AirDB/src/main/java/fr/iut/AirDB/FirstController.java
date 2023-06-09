package fr.iut.AirDB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}