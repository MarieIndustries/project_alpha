package com.marieindustries.project_alpha;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokeSteps {
    private final DomainSpecificLanguage dsl;

    public JokeSteps(final DomainSpecificLanguage dsl){
        this.dsl = dsl;
    }
    @When("the user adds {string}")
    public void the_user_adds(final String joke) {
        dsl.bddJokesService.addJokeToRepository(joke, "");
    }

    @When("the user adds {string} and {string}")
    public void the_user_adds_and(final String joke, final String punchline) {
        dsl.bddJokesService.addJokeToRepository(joke, punchline);
    }

    @Then("the available jokes should be:")
    public void the_available_jokes_should_be(final io.cucumber.datatable.DataTable dataTable) {
        List<Joke> expectedJokes =  dataTable.asMaps()
                .stream()
                .map(data -> {
                        final int id = Integer.parseInt(data.get("Id"));
                        final String joke = data.get("Joke");
                        final String punchline = data.getOrDefault("Punchline", "");
                        return new Joke(id, joke, punchline);
                    }
                ).toList();
        List<Joke> actualJokes = dsl.bddJokesService.getJokes();
        verifyExpectedAndActualJokes(expectedJokes, actualJokes);

    }

    private void verifyExpectedAndActualJokes(final List<Joke> expectedJokes, final List<Joke> actualJokes) {
        assertEquals(expectedJokes.size(), actualJokes.size());
        for(int i = 0; i < expectedJokes.size(); i++){
            Joke expectedJoke = expectedJokes.get(i);
            Joke actualJoke = actualJokes.get(i);
            assertAll(
                    ()-> assertEquals(expectedJoke.getId(), actualJoke.getId()),
                    ()-> assertEquals(expectedJoke.getJoke(), actualJoke.getJoke()),
                    ()-> assertEquals(expectedJoke.getPunchline(), actualJoke.getPunchline()));
        }
    }
}
