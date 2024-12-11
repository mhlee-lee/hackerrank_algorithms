/*
 * Complete the 'alternate' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun isValid(s: String): Boolean {
    for (i in 1 until s.length) {
        if (s[i-1] == s[i]) return false
    }
    return true
}

fun alternate(s: String): Int {
    // Write your code here
    val uniqueChars = s.toSet()
    var maxLength = 0
    uniqueChars.forEach { c1 ->
        uniqueChars.forEach { c2 ->
            if (c1 != c2) {
                val filteredString = s.filter { it == c1 || it == c2 }
                if (isValid(filteredString)) maxLength = maxOf(maxLength, filteredString.length)
            }
        }
    }
    return maxLength
}

fun main(args: Array<String>) {
    val l = readLine()!!.trim().toInt()

    val s = readLine()!!

    val result = alternate(s)

    println(result)
}
