import kotlin.collections.*

/*
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    // Write your code here
    val scoreRankMap = mutableMapOf<Int, Int>()
    var currentRank = 1
    ranked.forEach { score ->
        if (score !in scoreRankMap) scoreRankMap[score] = currentRank++ }

    var prevIndex = ranked.size - 1
    return player.map {
        var rank = -1
        for (rankIndex in prevIndex downTo 0) {
            val searchScore = ranked[rankIndex]

            if (searchScore > it) rank = scoreRankMap.getValue(searchScore) + 1
            else if (searchScore == it) rank = scoreRankMap.getValue(searchScore)

            prevIndex = rankIndex

            if (rank != -1) break
        }
        if (rank == -1 && prevIndex == 0) 1 else rank
    }.toTypedArray()
}

fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()

    val ranked = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val playerCount = readLine()!!.trim().toInt()

    val player = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}
