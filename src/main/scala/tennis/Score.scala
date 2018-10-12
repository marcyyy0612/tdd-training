package tennis

case class Score (val player1: Int, val player2: Int) {
    def even: String = this.player1 match {
        case 0 => "Love-All"
        case 1 => "Fifteen-All"
        case 2 => "Thirty-All"
        case _ => "Deuce"
    }

    def isEven() = {
        player1 == player2
    }

    def isDeuce()= {
        player1 >= 4 || player2 >= 4
    }
    
    def result() =
        toString(player1) + "-" + toString(player2)

    private def toString(tempScore: Int) = {
        tempScore match {
            case 0 => "Love"
            case 1 => "Fifteen"
            case 2 => "Thirty"
            case 3 => "Forty"
        }
    }
}
