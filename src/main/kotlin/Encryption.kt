import kotlin.math.sqrt

/*
 * Complete the 'encryption' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun encryption(s: String): String {
    // Write your code here
    val length = s.length
    val sq = sqrt(length.toDouble())
    var rows = sq.toInt()
    val columns = if (rows.toDouble() == sq) rows else rows + 1
    rows = if (rows*columns < s.length) rows + 1 else rows

    var out = ""
    for (column in 0 until columns) {
        for (row in 0 until rows) {
            val index = column + row * columns
            if (index < length) out += s[row * columns + column]
        }
        if (column != columns - 1) out += " "
    }
    return out
}

fun main(args: Array<String>) {

    val s = readLine()!!

    val result = encryption(s)

    println(result)
}
