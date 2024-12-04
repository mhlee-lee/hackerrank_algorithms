import kotlin.math.max

/*
 * Complete the 'extraLongFactorials' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

val value0 = Array(1) { 0 }

fun extraLongFactorials(n: Int): Unit {
    var v: Array<Int> = Array(1) { 1 }
    for (i in 2..n) {
        if (i/100 > 0) {
            val v1 = multiply(v, i%10, 0)
            val v2 = multiply(v, (i%100)/10, 1)
            val v3 = multiply(v, i/100, 2)
            v = sum(sum(v1, v2), v3)
        } else if (i/10 > 0) {
            val v1 = multiply(v, i%10, 0)
            val v2 = multiply(v, i/10, 1)
            v = sum(v1, v2)
        } else {
            v = multiply(v, i, 0)
        }
    }

    for (i in v.indexOfLast { it != 0 } downTo 0) {
        print(v[i])
    }
    println()
}

fun multiply(base: Array<Int>, n: Int, digit: Int): Array<Int> {
    val baseSize = base.indexOfLast { it != 0 } + 1

    if (n == 0) return value0
    if (n == 1) {
        val ret = Array(baseSize + 1 + digit) { 0 }
        for (i in 0 until baseSize) ret[i+digit] = base[i]
        return ret
    }

    val upperArray = Array(baseSize + 1 + digit) { 0 }
    val ret = Array(baseSize + 1 + digit) { 0 }

    for (i in 0 until baseSize) {
        val v = base[i] * n
        if (v >= 10) {
            upperArray[i + digit + 1] = v/10
            ret[i+digit] = v%10
        } else {
            ret[i+digit] = v
        }
    }

    val a = sum(upperArray, ret)
    return a
}

fun sum(a: Array<Int>, b: Array<Int>): Array<Int> {
    var aSize = a.indexOfLast {it != 0} + 1
    var bSize = b.indexOfLast {it != 0} + 1
    val maxSize = max(aSize + 1, bSize + 1)

    val ret = Array(maxSize + 1) { 0 }
    var upper = 0
    for (i in 0 until maxSize) {
        val v1 = if (aSize > i) a[i] else 0
        val v2 = if (bSize > i) b[i] else 0

        val sum = upper + v1 + v2 + ret[i]
        if (sum >= 10) {
            upper = sum / 10
            ret[i] = sum % 10
        } else {
            upper = 0
            ret[i] = sum
        }
    }
    if (upper > 0) {
        ret[maxSize] = upper
    }

    return ret
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    extraLongFactorials(n)
}
