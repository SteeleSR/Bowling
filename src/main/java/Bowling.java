public class Bowling {

    public int calculateScore(String results) {

        int score = 0;
        int resultsIndex = 0;

        String[] characters = results.replace("|", "").split("");
        for(String c : characters) {
            if (c.matches("[0-9]")) {
                score += Integer.parseInt(c);
            }
            if (c.matches("[X]")) {
                score += 10;
                if (characters[resultsIndex + 1].matches("[0-9X]")) {
                    if (characters[resultsIndex + 1].matches("[X]")) {
                        score += 10;
                    } else {
                        score += results.charAt(resultsIndex + 1);
                    }
                }
                if (characters[resultsIndex + 2].matches("[0-9X]")) {
                    score += results.charAt(resultsIndex + 2);
                }
            }
            resultsIndex++;
        }
        return score;
    }
}
