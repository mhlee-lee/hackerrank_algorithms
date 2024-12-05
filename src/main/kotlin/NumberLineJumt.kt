import kotlin.math.abs

/*
 * Complete the 'kangaroo' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER x1
 *  2. INTEGER v1
 *  3. INTEGER x2
 *  4. INTEGER v2
 */
fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
    // Write your code here
    if (x1 > x2 && v1 > v2 || x2 > x1 && v2 > v1) return "NO"
    val gap = abs(x1 - x2)
    val jumpGap = abs(v1 - v2)

    if (jumpGap == 0) return if (gap == 0) "YES" else "NO"
    return if (gap % jumpGap == 0) "YES"
    else "NO"
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val x1 = first_multiple_input[0].toInt()

    val v1 = first_multiple_input[1].toInt()

    val x2 = first_multiple_input[2].toInt()

    val v2 = first_multiple_input[3].toInt()

    val result = kangaroo(x1, v1, x2, v2)

    println(result)
}
