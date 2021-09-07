import java.util.Objects;

public class Bowling {

    public int calculateScore(String results) {

        int score = 0;
        double frame = 0;

        String[] resultsArray = results.replace("|", "").split("");
        for (int i = 0; i < resultsArray.length; i++) {
            String ball = resultsArray[i];
            if(frame == 10) {
                break;
            }

            if (isStrike(ball)) {
                String nextBall = resultsArray[i + 1];
                String ballAfterNext = resultsArray[i + 2];
                if(isSpare(ballAfterNext)) {
                    score += 20;
                } else {
                    score += 10 + convertBallToScore(nextBall) + convertBallToScore(ballAfterNext);
                }
                frame++;
            } else if(isSpare(ball)) {
                String nextBall = resultsArray[i + 1];
                String previousBall = resultsArray[i - 1];
                score += 10 - convertBallToScore(previousBall) + convertBallToScore(nextBall);
                frame += 0.5;
            } else {
                score += convertBallToScore(ball);
                frame += 0.5;
            }
        }
        return score;
    }

    public boolean isStrike(String ball) {
        return Objects.equals(ball, "X");
    }

    public boolean isSpare(String ball) {
        return Objects.equals(ball, "/");
    }

    public int convertBallToScore(String ball) {
        if (ball.matches("[X]")) {
            return 10;
        }
        if (ball.matches("[-]")) {
            return 0;
        }
            return Integer.parseInt(ball);
        }

}
