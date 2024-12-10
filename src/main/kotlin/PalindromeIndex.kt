/*
 * Complete the 'palindromeIndex' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun isPalindrome(s: String): Boolean {
    val halfLength = s.length/2
    val isOdd = s.length % 2 != 0

    var leftString = s.substring(0, halfLength)
    var rightString = s.substring(if (isOdd) halfLength + 1 else halfLength, s.length).reversed()
    return leftString == rightString
}

fun palindromeIndex(s: String): Int {
    val lastIndex = s.length - 1

    for (i in 0 until s.length/2) {
        if (s[i] != s[lastIndex - i]) {
            var subString = s.substring(i + 1, s.length - i)
            if (isPalindrome(subString)) return i
            subString = s.substring(i, s.length - i - 1)
            if (isPalindrome(subString)) return s.length - i - 1
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
