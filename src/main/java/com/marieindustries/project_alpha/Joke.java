package com.marieindustries.project_alpha;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String joke;
    @Column
    private String punchline;

    public Joke(){} //entity class must have a no-arg constructor

    public Joke(final int id, final String joke, final String punchline) {
        this.id = id;
        this.joke = joke;
        this.punchline = punchline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke1 = (Joke) o;
        return id == joke1.id && Objects.equals(joke, joke1.joke) && Objects.equals(punchline, joke1.punchline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, joke, punchline);
    }
}
