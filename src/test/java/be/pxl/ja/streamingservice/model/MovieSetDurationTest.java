package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieSetDurationTest {
    @Test
    public void negativeDurationBecomesPositive(){
        //ARRANGE
        Movie movie = new Movie("Titanic",Rating.OLDER_KIDS);

        //ACT
        movie.setDuration(-125);

        //ASSERT
        assertEquals(125,movie.getDuration());
    }

    @Test
    public void positiveDurationBecomesPositive(){
        //ARRANGE
        Movie movie = new Movie("Titanic",Rating.OLDER_KIDS);

        //ACT
        movie.setDuration(125);

        //ASSERT
        assertEquals(125,movie.getDuration());
    }

}