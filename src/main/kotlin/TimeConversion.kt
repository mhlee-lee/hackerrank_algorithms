import kotlin.collections.*

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun timeConversion(s: String): String {
    val (hour, min, secPart) = s.split(':')
    val sec = secPart.substring(0, 2)
    val ampm = secPart.substring(2, 4)

    val militaryHour = if (ampm == "AM") (hour.toInt() % 12).let { if (it < 10) "0$it" else it.toString() }
    else (hour.toInt() % 12 + 12).let { if (it < 10) "0$it" else it.toString() }

    return "$militaryHour:$min:$sec"
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
