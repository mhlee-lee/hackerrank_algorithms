/*
 * Complete the 'extraLongFactorials' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

fun extraLongFactorials(n: Int): Unit {
    val value = Array(5000) { 0 }
    value[0] = 1
    var digit = 1

    var carry = 0
    for (i in 2..n) {
        for (valueIdx in 0 until digit) {
            val v = value[valueIdx] * i + carry
            carry = v/10
            value[valueIdx] = v%10
        }

        val carryLength = if (carry == 0) 0 else carry.toString().length
        for (i in 0 until carryLength) {
            value[digit + i] = carry%10
            carry /= 10
        }
        digit += carryLength
    }

    val lastIndex = value.indexOfLast { it != 0 }
    for (i in lastIndex downTo 0) {
        print(value[i])
    }
    println()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    extraLongFactorials(n)
}
