/*
 * Complete the 'gridSearch' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING_ARRAY G
 *  2. STRING_ARRAY P
 * link : https://www.hackerrank.com/challenges/the-grid-search/problem?isFullScreen=true
 * 실패
 */

fun gridSearch(G: Array<String>, P: Array<String>): String {
    // Write your code here
    val pXLen = P[0].length
    val pYlen = P.size
    val gXLen = G[0].length
    val gYLen = G.size
    val gMaxXindex = gXLen - pXLen - 1
    val gMaxYindex = gYLen - pYlen - 1


    for (gy in 0..gMaxYindex) {
        for (gx in 0 until gMaxXindex) {
            var match = true
            for (py in 0 until pYlen) {
                if (G[gy + py].substring(gx, gx + pXLen) != P[py]) {
                    match = false
                    break;
                }
            }

            if (match) return "YES"
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val R = first_multiple_input[0].toInt()

        val C = first_multiple_input[1].toInt()

        val G = Array<String>(R, { "" })
        for (i in 0 until R) {
            val GItem = readLine()!!
            G[i] = GItem
        }

        val second_multiple_input = readLine()!!.trimEnd().split(" ")

        val r = second_multiple_input[0].toInt()

        val c = second_multiple_input[1].toInt()

        val P = Array<String>(r, { "" })
        for (i in 0 until r) {
            val PItem = readLine()!!
            P[i] = PItem
        }

        val result = gridSearch(G, P)

        println(result)
    }
}
