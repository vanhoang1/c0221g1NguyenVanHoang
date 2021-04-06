package ss8_cleanCode.BaiTap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score = "";

        boolean twoPlayersScoreEqual = scorePlayer1 == scorePlayer2;
        if (twoPlayersScoreEqual) {
           score=socreEqual(scorePlayer1);
        } else {
            boolean playerScoreIsGreaterThanOrEqualTo4 = scorePlayer1 >= 4 || scorePlayer2 >= 4;
            if (playerScoreIsGreaterThanOrEqualTo4) {
                score = advantagetTest(scorePlayer1, scorePlayer2);
            } else {
               score=normalScore(scorePlayer1,scorePlayer2);
            }
        }
        return score;
    }

    public static String advantagetTest(int scorePlayer1, int scorePlayer2) {
        int subtractionResult = scorePlayer1 - scorePlayer2;
        boolean subtractionResultEqua1 = subtractionResult == 1;
        if (subtractionResultEqua1) return "Advantage player1";
        else {
            boolean subtractionResultEquaMinus1 = subtractionResult == -1;
            if (subtractionResultEquaMinus1) return "Advantage player2";
            else {
                boolean subtractionResultThan2 = subtractionResult >= 2;
                if (subtractionResultThan2) return "Win for player1";
                else return "Win for player2";
            }
        }
    }
    public  static  String socreEqual( int scorePlayer1 ){
        switch (scorePlayer1) {
            case 0:
                return  "Love-All";

            case 1:
                return  "Fifteen-All";

            case 2:
                return  "Thirty-All";

            case 3:
                return  "Forty-All";

            default:
                return  "Deuce";

        }
    }
    public  static  String normalScore(int scorePlayer1 , int scorePlayer2){
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                score.append("-");
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }
}
