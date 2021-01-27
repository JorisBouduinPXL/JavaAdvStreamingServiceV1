package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MovieIsLongPlayingTimeTest {
    private Movie movie;

    @BeforeEach
    public void init(){
        movie = new Movie("Titanic", Rating.TEENS);
    }

    @Test
    public void movieWithDurationShorterThanLongPlayingTimeReturnsFalse(){
        movie.setDuration(Movie.LONG_PLAYING_TIME - 1);

        assertFalse(movie.isLongPlayingTime());
    }

    @Test
    public void movieWithDurationExactlyLongPlayingTimeReturnsTrue(){
        movie.setDuration(Movie.LONG_PLAYING_TIME);

        assertTrue(movie.isLongPlayingTime());
    }

    @Test
    public void movieWithDurationLongerThanLongPlayingTimeReturnsTrue (){
        movie.setDuration(Movie.LONG_PLAYING_TIME + 1);

        assertTrue(movie.isLongPlayingTime());
    }

}
