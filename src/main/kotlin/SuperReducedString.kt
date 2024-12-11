/*
 * Complete the 'superReducedString' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun superReducedString(s: String): String {
    // Write your code here
    val reduces = mutableListOf<Char>()
    s.forEach {
        reduces.add(it)
        while (reduces.size > 1 && reduces[reduces.size - 1] == reduces[reduces.size - 2]) {
            reduces.removeLast()
            reduces.removeLast()
        }
    }
    return if (reduces.isEmpty()) "Empty String" else reduces.joinToString("")
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = superReducedString(s)

    println(result)
}
