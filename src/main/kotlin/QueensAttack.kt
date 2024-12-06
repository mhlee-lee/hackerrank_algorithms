import kotlin.math.abs
import kotlin.math.min

/*
 * Complete the 'queensAttack' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER r_q
 *  4. INTEGER c_q
 *  5. 2D_INTEGER_ARRAY obstacles
 */

enum class ARROW {
    LEFT, RIGHT, UP, DOWN, LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN;
}

fun queensAttack(n: Int, k: Int, x: Int, y: Int, obstacles: Array<Array<Int>>): Int {
    val leftCount = x - 1
    val rightCount = n - x
    val upCount = n - y
    val downCount = y - 1
    val leftUpCount = min(leftCount, upCount)
    val leftDownCount = min(leftCount, downCount)
    val rightUpCount = min(rightCount, upCount)
    val rightDownCount = min(rightCount, downCount)
    val totalcount = leftCount + rightCount + upCount + downCount + leftUpCount + rightUpCount + leftDownCount + rightDownCount


    val availableObsMap = mutableMapOf<ARROW, Int>()
    obstacles.forEach { obstacle ->
        val verticalGap = x - obstacle[0]
        val horizonGap = y - obstacle[1]

        var removeCount = 0
        val arrow = if (horizonGap == 0) {
            if (verticalGap > 0) ARROW.LEFT to obstacle[0] else ARROW.RIGHT to (n - obstacle[0] + 1)
        } else if (verticalGap == 0) {
            if (horizonGap > 0) ARROW.DOWN to obstacle[1] else ARROW.UP to (n - obstacle[1] + 1)
        } else if (abs(verticalGap) == abs(horizonGap)) {
            if (verticalGap > 0 && horizonGap > 0) ARROW.LEFT_DOWN to min(obstacle[0], obstacle[1])
            else if (verticalGap > 0 && horizonGap < 0) ARROW.LEFT_UP to min(obstacle[0], n - obstacle[1] + 1)
            else if (verticalGap < 0 && horizonGap > 0) ARROW.RIGHT_DOWN to min(n - obstacle[0] + 1, obstacle[1])
            else ARROW.RIGHT_UP to min(n - obstacle[0] + 1, n - obstacle[1] + 1)
        } else null

        if (arrow != null) {
            if (availableObsMap[arrow.first] != null) {
                if (availableObsMap[arrow.first]!! < arrow.second) {
                    availableObsMap[arrow.first] = arrow.second
                }
            } else {
                availableObsMap[arrow.first] = arrow.second
            }
        }
    }

    return totalcount - availableObsMap.values.sum()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val second_multiple_input = readLine()!!.trimEnd().split(" ")

    val r_q = second_multiple_input[0].toInt()

    val c_q = second_multiple_input[1].toInt()

    val obstacles = Array<Array<Int>>(k, { Array<Int>(2, { 0 }) })

    for (i in 0 until k) {
        obstacles[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}
