package leetcode

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    val totalOpenCloseCount = n * 2

    fun recur(current: String, open: Int, close: Int) {
        if (current.length == totalOpenCloseCount) {
            result.add(current)
            return
        }

        if (open < n) recur("$current(", open + 1, close)
        if (close < open) recur("$current)", open, close + 1)
    }

    recur("", 0, 0)

    return result
}



fun main() {
    println(generateParenthesis(3)) // ((())), (())(), ()(()), (()()) 111000 110100 110010 101100 101010 () () ()
    println(generateParenthesis(2)) // (()) ()()
    println(generateParenthesis(1)) // ()
}
