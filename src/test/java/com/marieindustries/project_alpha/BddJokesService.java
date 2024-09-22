package com.marieindustries.project_alpha;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class BddJokesService {
    private final BddMockMvcService mockMvcService;
    private final ObjectMapper objectMapper;

    public BddJokesService(final BddMockMvcService mockMvcService, final ObjectMapper objectMapper){
        this.mockMvcService = mockMvcService;
        this.objectMapper = objectMapper;
    }

    public void addJokeToRepository(final int id, final String joke, final String punchline){
        final Joke constructedJoke = new Joke(id, joke, punchline);
        mockMvcService.post("/api/jokes", constructedJoke);
    }

    public List<Joke> getJokes() {
        MvcResult mvcResult = mockMvcService.get("/api/jokes");
        return convertMvcResultToList(mvcResult);
    }

    private List<Joke> convertMvcResultToList(final MvcResult mvcResult) {
        try {
            String contentAsString = mvcResult.getResponse().getContentAsString();
            //gotchya - objectMapper is needed with a TypeReference
            return objectMapper.readValue(contentAsString, new TypeReference<>(){});
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteJokeFromRepository(final Integer jokeId) {
        mockMvcService.delete("/api/jokes", jokeId);
    }

    public void updateJokeById(final Joke joke) {
        mockMvcService.put("/api/jokes", joke);
    }
}
