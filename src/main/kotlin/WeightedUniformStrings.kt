/*
 * Complete the 'weightedUniformStrings' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER_ARRAY queries
 */

fun weightedUniformStrings(s: String, queries: Array<Int>): Array<String> {
    // Write your code here
    val weights = mutableSetOf<Int>()
    val baseWeight = 'a'.code - 1

    var prevChar = '_'
    var prevWeight = 0
    s.forEach { ch ->
        val w = ch.code - baseWeight

        if (prevChar == ch) prevWeight += w
        else prevWeight = w

        prevChar = ch
        weights.add(prevWeight)
    }

    return queries.map { if (it in weights) "Yes" else "No" }.toTypedArray()
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val queriesCount = readLine()!!.trim().toInt()

    val queries = Array<Int>(queriesCount, { 0 })
    for (i in 0 until queriesCount) {
        val queriesItem = readLine()!!.trim().toInt()
        queries[i] = queriesItem
    }

    val result = weightedUniformStrings(s, queries)

    println(result.joinToString("\n"))
}
