/*
 * Complete the 'organizingContainers' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts 2D_INTEGER_ARRAY container as parameter.
 */

fun organizingContainers(container: Array<Array<Int>>): String {
    // Write your code here
    val n = container.size
    val rowSum = IntArray(n) { i -> container[i].sum() }
    val colSum = IntArray(n) { j -> container.sumOf { it[j] } }
    return if (rowSum.sorted() == colSum.sorted()) "Possible" else "Impossible"
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()

        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            container[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val result = organizingContainers(container)

        println(result)
    }
}
