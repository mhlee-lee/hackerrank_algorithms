import kotlin.collections.*
import kotlin.math.max

/*
 * Complete the 'pickingNumbers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun pickingNumbers(a: Array<Int>): Int {
    // number, count
    val upper = mutableMapOf<Int, Int>()
    val under = mutableMapOf<Int, Int>()

    a.forEach {
        upper.computeIfPresent(it - 1) { _, v -> v + 1 }
        under.computeIfPresent(it + 1) { _, v -> v + 1 }
        upper[it] = (upper[it] ?: 0) + 1
        under[it] = (under[it] ?: 0) + 1
    }

    return max(under.values.max(), upper.values.max())
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = pickingNumbers(a)

    println(result)
}
