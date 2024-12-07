import kotlin.math.abs

/*
 * Complete the 'formingMagicSquare' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY s as parameter.
 */

val correctAnswer = arrayOf(
    arrayOf(8, 3, 4),
    arrayOf(1, 5, 9),
    arrayOf(6, 7, 2),
)

val circleIndex = arrayOf(
    Pair(0, 0),
    Pair(1, 0),
    Pair(2, 0),
    Pair(2, 1),
    Pair(2, 2),
    Pair(1, 2),
    Pair(0, 2),
    Pair(0, 1),
)

fun formingMagicSquare(s: Array<Array<Int>>): Int {
    var minValue = 1000
    for (i in 0..6 step 2) {
        val value = arrayOf(0,0)
        circleIndex.forEachIndexed { index, (x, y) ->
            val comIndex = (index + i) % 8
            val (comX, comY) = circleIndex[comIndex]
            value[0] += abs(s[x][y] - correctAnswer[comX][comY])
            value[1] += abs(s[x][y] - correctAnswer[comY][comX])
        }

        val min = value.min()
        if (minValue > min) minValue = min
    }

    return minValue + abs(s[1][1] - 5)
}

fun main(args: Array<String>) {
    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}
