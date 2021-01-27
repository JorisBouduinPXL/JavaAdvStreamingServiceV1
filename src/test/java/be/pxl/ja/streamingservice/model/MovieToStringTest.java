package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MovieToStringTest {
    private Movie movie;
    @BeforeEach
    public void init(){
        movie = new Movie("Titanic", Rating.TEENS);

    }

    @Test
    public void toStringGivesTitleOfMovieTest(){
        String toString = movie.toString();
        assertTrue(toString.contains(movie.getTitle()));
    }

    @Test
    public void toStringGivesYearOfMovieTest(){
        movie.setReleaseDate(LocalDate.of(1997,12,12));
        String toString = movie.toString();
        assertTrue(toString.contains("1997"));
    }

    // test indien er geen releasedat gekend is ...

}