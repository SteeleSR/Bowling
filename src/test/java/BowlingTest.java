import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    @Test
    public void shouldReturn0WhenAllFramesAreMisses() {
        Bowling bowling = new Bowling();
        assertEquals(0, bowling.calculateScore("--|--|--|--|--|--|--|--|--|--||"));
    }

    @Test
    public void shouldReturn10WhenAllFramesScore1() {
        Bowling bowling = new Bowling();
        assertEquals(10, bowling.calculateScore("1-|1-|1-|1-|1-|1-|1-|1-|1-|1-||"));
    }

    @Test
    public void shouldReturn15WhenFramesAreHalf1Half2() {
        Bowling bowling = new Bowling();
        assertEquals(15, bowling.calculateScore("1-|1-|1-|1-|1-|2-|2-|2-|2-|2-||"));
    }

    @Test
    public void shouldReturn20WhenFirstFrameIsStrikeFollowedBy1ForRemainingFrames() {
        Bowling bowling = new Bowling();
        assertEquals(20, bowling.calculateScore("X|1-|1-|1-|1-|1-|1-|1-|1-|1-||"));
    }

    @Test
    public void shouldReturn20WhenFirstTwoFramesAreStrikesFollowedBy1ForRemainingFrames() {
        Bowling bowling = new Bowling();
        assertEquals(40, bowling.calculateScore("X|X|1-|1-|1-|1-|1-|1-|1-|1-||"));
    }

    @Test
    public void shouldReturn20WhenFirstFrameIsASpareFollowedBy1ForRemainingFrames() {
        Bowling bowling = new Bowling();
        assertEquals(20, bowling.calculateScore("3/|1-|1-|1-|1-|1-|1-|1-|1-|1-||"));
    }

    @Test
    public void shouldReturn150WhenWhenEveryFrameIsASpareFollowedBy5ForBonusBall() {
        Bowling bowling = new Bowling();
        assertEquals(150, bowling.calculateScore("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"));
    }

    @Test
    public void shouldReturn167WhenTheResultsAreIsKatalystDemoStringFour() {
        Bowling bowling = new Bowling();
        assertEquals(167, bowling.calculateScore("X|7/|9-|X|-8|8/|-6|X|X|X||81"));
    }

}
