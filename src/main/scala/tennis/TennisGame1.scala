package tennis


class TennisGame1(val player1Name: String, val player2Name: String) extends TennisGame {
//    var score.player1: Int = 0
//    var score.player2: Int = 0
    var score = Score(0, 0)

    def advantage(playerName: String) = s"Advantage ${playerName}"

    def winFor(playerName: String) = s"Win for ${playerName}"

    def wonPoint(playerName: String) {
        if (playerName == player1Name)
            score = score.copy(player1 = score.player1 + 1)
        else
            score = score.copy(player2 = score.player2 + 1)
    }

    def calculateScore(): String = {
        var displayScore: String = ""

        def duce = {
            val minusResult = score.player1 - score.player2
            if (minusResult == 1) displayScore = advantage(player1Name)
            else if (minusResult == -1) displayScore = advantage(player2Name)
            else if (minusResult >= 2) displayScore = winFor(player1Name)
            else displayScore = winFor(player2Name)
        }

        if (score.isEven()) {
            displayScore = score.even
        }
        else if (score.isDeuce) {
            duce
        }
        else {
            displayScore = score.result()
        }
        return displayScore
    }


}