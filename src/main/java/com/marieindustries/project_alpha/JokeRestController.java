package com.marieindustries.project_alpha;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jokes")
public class JokeRestController {
    private final JokesRepository jokesRepository;

    public JokeRestController(final JokesRepository jokesRepository){
        this.jokesRepository = jokesRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Joke> getAll(){
        return jokesRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Joke addJoke(@RequestBody final Joke joke){
        return jokesRepository.save(joke);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJoke(@PathVariable("id") final String id){
        jokesRepository.deleteById(Integer.parseInt(id));
    }

}
