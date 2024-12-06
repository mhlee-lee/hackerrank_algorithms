/*
 * Complete the 'palindromeIndex' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun isEquals(s: String, reversString: String): Boolean {
    for (i in s.indices) {
        if (s[i] != reversString[s.length - i - 1]) return false
    }
    return true
}

fun palindromeIndex(s: String): Int {
    // Write your code here
    val lastIndex = s.length - 1

    for (i in 0..lastIndex) {
        if (s[i] != s[lastIndex - i]) {
            val startIndex = i + 1
            val endIndex = lastIndex -i

            val s1 = s.substring(i + 1, s.length -i)
            if (isEquals(s1.substring(0, s1.length/2), s1.substring(s1.length -  s1.length/2,  s1.length))) return i
            val s2 = s.substring(i, s.length -i -1)
            if (isEquals(s2.substring(0, s2.length/2), s2.substring(s2.length -  s2.length/2,  s2.length))) return s.length -i -1
            return -1
        }
    }
    return -1
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = palindromeIndex(s)

        println(result)
    }
}
