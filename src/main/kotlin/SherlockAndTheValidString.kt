/*
 * Complete the 'isValid' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isValid(s: String): String {
    // Write your code here
    val charCountMap = s.groupingBy { it }.eachCount()
    val countMap = charCountMap.values.groupingBy { it }.eachCount()

    return if (countMap.size > 2) "NO"
    else if (countMap.size == 2) {
        if (countMap[1] == 1) "YES"
        else {
            val (freq1, count1) = countMap.entries.elementAt(0)
            val (freq2, count2) = countMap.entries.elementAt(1)

            val keyGap = freq1 - freq2

            if (keyGap == 1 && count1 == 1) "YES"
            else if (keyGap == -1 && count2 == 1) "YES"
            else "NO"
        }
    }
    else "YES"
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = isValid(s)

    println(result)
}
