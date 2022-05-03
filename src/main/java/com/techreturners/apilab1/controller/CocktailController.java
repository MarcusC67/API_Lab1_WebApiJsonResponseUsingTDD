package com.techreturners.apilab1.controller;

import com.techreturners.apilab1.model.Cocktail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CocktailController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/cocktailnow")
    public String coffeeLover() {
        return "I need a cocktail now!";
    }

    @GetMapping("/cocktail")
    public Cocktail cocktail(@RequestParam(value = "name", defaultValue = "manhattan") String name) {
        return new Cocktail(counter.incrementAndGet(), name);
    }
}