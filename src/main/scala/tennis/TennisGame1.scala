package tennis


class TennisGame1(val player1Name: String, val player2Name: String) extends TennisGame {
    var player1_score: Int = 0
    var player2_score: Int = 0

    def advantage(playerName: String) = s"Advantage ${playerName}"

    def winFor(playerName: String) = s"Win for ${playerName}"

    def wonPoint(playerName: String) {
        if (playerName == player1Name)
            player1_score += 1
        else
            player2_score += 1
    }

    def calculateScore(): String = {
        var score: String = ""
        var tempScore = 0

        def even = {
            score = player1_score match {
                case 0 => "Love-All"
                case 1 => "Fifteen-All"
                case 2 => "Thirty-All"
                case _ => "Deuce"

            }
        }

        if (player1_score == player2_score) {
            even
        }
        else if (player1_score >= 4 || player2_score >= 4) {
            val minusResult = player1_score - player2_score
            if (minusResult == 1) score = advantage(player1Name)
            else if (minusResult == -1) score = advantage(player2Name)
            else if (minusResult >= 2) score = winFor(player1Name)
            else score = winFor(player2Name)
        }
        else {
            for (i <- 1 until 3 by 1) {
                if (i == 1) tempScore = player1_score
                else {
                    score += "-"; tempScore = player2_score;
                }
                val tempScore2 = tempScore match {
                    case 0 => "Love"
                    case 1 => "Fifteen"
                    case 2 => "Thirty"
                    case 3 => "Forty"
                }
                score += tempScore2
            }
        }
        return score
    }

}